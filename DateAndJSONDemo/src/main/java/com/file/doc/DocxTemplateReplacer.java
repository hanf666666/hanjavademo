package com.file.doc;

/**
 * @author Hj
 * @date 2026/9/9
 */

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
}
