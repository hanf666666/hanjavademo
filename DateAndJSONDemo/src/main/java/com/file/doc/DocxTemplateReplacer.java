package com.file.doc;

/**
 * @author Hj
 * @date 2026/9/9
 */

import org.apache.poi.xwpf.usermodel.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Word 模板替换工具（基于 Apache POI）
 * 支持段落和表格内的文本占位符替换，占位符格式：{{key}}
 */
public class DocxTemplateReplacer {

    /**
     * 替换模板中的所有占位符，并输出新文档
     * @param templatePath 模板文件路径
     * @param outputPath   输出文件路径
     * @param replacements 替换映射表，key 为占位符名称（不含 {{ 和 }}），value 为替换文本
     */
    public static void replaceAndSave(String templatePath, String outputPath,
                                      Map<String, String> replacements) throws IOException {
        try (XWPFDocument doc = new XWPFDocument(new FileInputStream(templatePath))) {
            // 1. 替换所有段落中的占位符
            for (XWPFParagraph paragraph : doc.getParagraphs()) {
                replaceInParagraph(paragraph, replacements);
            }

            // 2. 替换所有表格中的占位符
            for (XWPFTable table : doc.getTables()) {
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph paragraph : cell.getParagraphs()) {
                            replaceInParagraph(paragraph, replacements);
                        }
                    }
                }
            }

            // 3. 也可以处理页眉页脚（若有需要可取消注释）
            // 替换页眉
            for (XWPFHeader header : doc.getHeaderList()) {
                for (XWPFParagraph p : header.getParagraphs()) {
                    replaceInParagraph(p, replacements);
                }
            }
            // 替换页脚
            for (XWPFFooter footer : doc.getFooterList()) {
                for (XWPFParagraph p : footer.getParagraphs()) {
                    replaceInParagraph(p, replacements);
                }
            }

            // 写出新文档
            try (FileOutputStream out = new FileOutputStream(outputPath)) {
                doc.write(out);
            }
        }
    }

    /**
     * 替换模板中的所有占位符，并直接输出为 PDF 文件。
     * <p>说明：POI 本身不支持 docx 直接渲染为 PDF，因此本方法会先按原逻辑把占位符
     * 替换到一份临时 docx（保留 Word 样式），再调用本机已安装的办公软件渲染成 PDF，
     * 完成后自动删除临时 docx。</p>
     *
     * @param templatePath  模板文件路径（docx）
     * @param pdfOutputPath 输出的 PDF 文件路径
     * @param replacements  替换映射表，key 为占位符名称（不含 {{ 和 }}），value 为替换文本
     */
    public static void replaceAndSaveAsPdf(String templatePath, String pdfOutputPath,
                                           Map<String, String> replacements) throws IOException {
        File tempDocx = File.createTempFile("docx-template-replaced-", ".docx");
        try {
            replaceAndSave(templatePath, tempDocx.getAbsolutePath(), replacements);
            convertDocxToPdf(tempDocx.getAbsolutePath(), pdfOutputPath);
        } finally {
            tempDocx.delete();
        }
    }

    /**
     * 将 docx 文件渲染为 PDF（依赖本机已安装的办公软件，按优先级自动探测）：
     * <ol>
     *     <li>LibreOffice（soffice 命令行，headless 模式，最稳定）；</li>
     *     <li>Microsoft Office 的 Word COM 接口（Word.Application）；</li>
     *     <li>WPS 的 COM 接口（Kwps.Application）。</li>
     * </ol>
     * 均不可用时抛出 IOException 并给出安装提示。
     *
     * @param docxPath      源 docx 文件路径
     * @param pdfOutputPath 输出的 PDF 文件路径
     */
    public static void convertDocxToPdf(String docxPath, String pdfOutputPath) throws IOException {
        File pdfFile = new File(pdfOutputPath);
        File parent = pdfFile.getAbsoluteFile().getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        if (convertByLibreOffice(docxPath, pdfOutputPath)) {
            return;
        }
        if (convertByOfficeCom(docxPath, pdfOutputPath, "Word.Application")) {
            return;
        }
        if (convertByOfficeCom(docxPath, pdfOutputPath, "Kwps.Application")) {
            return;
        }
        throw new IOException("docx 转 PDF 失败：未找到可用的转换器。请安装 LibreOffice（soffice）"
                + " 或 Microsoft Office / WPS 后重试。源文件：" + docxPath);
    }

    /**
     * 替换单个段落中的占位符，并尽量保留原 run 样式
     *
     * Word 中的一段文字可能被拆成多个 run（例如"目标地点：重庆"保存后常被切成
     * "目标地点："和"重庆"两个 run），且每个 run 都带有自己的格式（rPr：字体、字号、
     * 加粗、颜色等）。
     *
     * 处理策略：
     * 1) 占位符完整落在单个 run 内：直接 setText 修改文本，run 的 rPr 保持不变，样式不丢；
     * 2) 占位符被拆散到多个 run：先把这些 run 的文本拼起来整体替换，再写回第一个 run
     *    （沿用第一个 run 的格式），并删除被合并掉的其余 run。
     */
    private static void replaceInParagraph(XWPFParagraph paragraph, Map<String, String> replacements) {
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs == null || runs.isEmpty()) {
            return;
        }

        // 1) 先在单个 run 内查找并替换（仅改文本，保留 run 的 rPr，因此样式不会消失）
        for (XWPFRun run : runs) {
            String text = run.getText(0);
            if (text == null || text.isEmpty()) {
                continue;
            }
            String newText = replacePlaceholders(text, replacements);
            if (!newText.equals(text)) {
                run.setText(newText, 0);
            }
        }

        // 2) 处理被拆到多个 run 的占位符：拼接全段文本再替换
        StringBuilder sb = new StringBuilder();
        for (XWPFRun run : paragraph.getRuns()) {
            String t = run.getText(0);
            if (t != null) {
                sb.append(t);
            }
        }
        String merged = sb.toString();
        String replaced = replacePlaceholders(merged, replacements);
        if (!replaced.equals(merged)) {
            // 写回第一个 run（沿用它的样式），删除其余 run，避免新建 run 导致格式丢失
            paragraph.getRuns().get(0).setText(replaced, 0);
            while (paragraph.getRuns().size() > 1) {
                paragraph.removeRun(1);
            }
        }
    }

    /**
     * 按替换映射依次替换占位符文本
     */
    private static String replacePlaceholders(String text, Map<String, String> replacements) {
        String result = text;
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }
        return result;
    }

    // ==================== docx 转 PDF 的辅助方法 ====================

    /**
     * 尝试用 LibreOffice（soffice）转换，搜索常见安装位置
     */
    private static boolean convertByLibreOffice(String docxPath, String pdfOutputPath) {
        List<String> candidates = new ArrayList<>();
        candidates.add("soffice"); // 已在 PATH 中
        candidates.add("C:\\Program Files\\LibreOffice\\program\\soffice.exe");
        candidates.add("C:\\Program Files (x86)\\LibreOffice\\program\\soffice.exe");
        candidates.add("C:\\Program Files\\LibreOffice\\program\\soffice.com");
        for (String candidate : candidates) {
            try {
                if (!"soffice".equals(candidate) && !new File(candidate).exists()) {
                    continue;
                }
                if (runSoffice(candidate, docxPath, pdfOutputPath)) {
                    return true;
                }
            } catch (Exception ignored) {
                // 继续尝试下一种转换器
            }
        }
        return false;
    }

    /**
     * 调用 soffice 的 headless 模式执行转换。
     * soffice 要求 --outdir 为已存在的目录，且转换后的 PDF 文件名与 docx 同名（扩展名不同），
     * 因此使用独立临时目录 + 独立用户 profile，成功后再拷贝到目标路径。
     */
    private static boolean runSoffice(String soffice, String docxPath, String pdfOutputPath) throws Exception {
        File docx = new File(docxPath);
        String baseName = docx.getName();
        if (baseName.toLowerCase().endsWith(".docx")) {
            baseName = baseName.substring(0, baseName.length() - ".docx".length());
        }
        File workDir = new File(System.getProperty("java.io.tmpdir"), "docx2pdf_" + System.nanoTime());
        if (!workDir.mkdirs()) {
            return false;
        }
        try {
            String profilePath = new File(workDir, "profile").getAbsolutePath().replace("\\", "/");
            List<String> command = new ArrayList<>();
            command.add(soffice);
            command.add("-env:UserInstallation=file:///" + profilePath);
            command.add("--headless");
            command.add("--convert-to");
            command.add("pdf");
            command.add("--outdir");
            command.add(workDir.getAbsolutePath());
            command.add(docx.getAbsolutePath());

            Process process = new ProcessBuilder(command).redirectErrorStream(true).start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[soffice] " + line);
                }
            }
            if (process.waitFor() == 0) {
                File converted = new File(workDir, baseName + ".pdf");
                if (converted.exists() && converted.length() > 0) {
                    copyFile(converted, new File(pdfOutputPath));
                    return true;
                }
            }
            return false;
        } finally {
            deleteRecursively(workDir);
        }
    }

    /**
     * 通过 PowerShell 脚本调用 Office / WPS 的 COM 接口，把 docx 另存为 PDF。
     * 使用 -File 传参而非内联字符串，可避免中文路径与引号的转义问题。
     */
    private static boolean convertByOfficeCom(String docxPath, String pdfOutputPath, String progId) {
        File psFile = null;
        try {
            psFile = File.createTempFile("docx2pdf-", ".ps1");
            String script = "param([string]$DocxPath, [string]$PdfPath, [string]$ProgId)\n"
                    + "$ErrorActionPreference = 'Stop'\n"
                    + "try { $app = New-Object -ComObject $ProgId } catch { exit 50 }\n"
                    + "try { $app.Visible = $false } catch {}\n"
                    + "try { $app.DisplayAlerts = 0 } catch {}\n"
                    + "try {\n"
                    + "  $doc = $app.Documents.Open($DocxPath)\n"
                    + "  if (Test-Path $PdfPath) { Remove-Item $PdfPath -Force }\n"
                    + "  try { $doc.SaveAs2($PdfPath, 17) } catch { $doc.SaveAs($PdfPath, 17) }\n"
                    + "  $doc.Close(0)\n"
                    + "  try { $app.Quit() } catch {}\n"
                    + "  if (Test-Path $PdfPath) { exit 0 } else { exit 51 }\n"
                    + "} catch {\n"
                    + "  try { $doc.Close(0) } catch {}\n"
                    + "  try { $app.Quit() } catch {}\n"
                    + "  exit 51\n"
                    + "}\n";
            // PowerShell 5.1 对无 BOM 的 UTF-8 脚本按本地 ANSI 解码，中文路径会乱码，必须写入 BOM
            writeScriptWithUtf8Bom(psFile, script);

            Process process = new ProcessBuilder(
                    "powershell.exe",
                    "-NoProfile", "-NonInteractive",
                    "-ExecutionPolicy", "Bypass",
                    "-File", psFile.getAbsolutePath(),
                    "-DocxPath", new File(docxPath).getAbsolutePath(),
                    "-PdfPath", new File(pdfOutputPath).getAbsolutePath(),
                    "-ProgId", progId)
                    .redirectErrorStream(true).start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[powershell] " + line);
                }
            }
            return process.waitFor() == 0 && new File(pdfOutputPath).exists();
        } catch (Exception e) {
            return false;
        } finally {
            if (psFile != null) {
                psFile.delete();
            }
        }
    }

    /**
     * 以 UTF-8 BOM 编码写入文件（供 PowerShell 脚本使用）
     */
    private static void writeScriptWithUtf8Bom(File file, String content) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}); // UTF-8 BOM
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }
    }

    private static void copyFile(File src, File dest) throws IOException {
        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void deleteRecursively(File dir) {
        File[] children = dir.listFiles();
        if (children != null) {
            for (File child : children) {
                if (child.isDirectory()) {
                    deleteRecursively(child);
                } else {
                    child.delete();
                }
            }
        }
        dir.delete();
    }
}
