package com.file.pdf;

/**
 * @author Hj
 * @date 2026/5/21
 */

import cn.hutool.core.io.FileUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;

/**
 * 使用 Hutool + POI 读取高德打车行程单 Word 文档中的金额数据
 */
public class pdfRedgaodeDemo {

    //    // 金额匹配正则：匹配整数或最多两位小数的数字（可选 ? 符号）
//    private static final Pattern AMOUNT_PATTERN = Pattern.compile("(?:?|￥)?\\s*(\\d+(?:\\.\\d{1,2})?)");

    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles("C:\\Users\\Administrator\\AppData\\Roaming\\Foxmail7", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getPath().indexOf("电子行程单.pdf") > -1
                ) {
//                    System.out.println(pathname.getPath());
                    return true;
                }
                return false;
            }
        });
        for (File file : files) {
//            System.out.println("正在处理文件：" + file.getPath());

            // 使用 Hutool 的 FileUtil 检查文件是否存在
            File pdfFile = FileUtil.file(file.getPath());


            // 使用 try-with-resources 确保资源正确释放
            try (PDDocument document = PDDocument.load(pdfFile)) {


                // 使用 PDFBox 的 PDFTextStripper 提取所有文本
                PDFTextStripper stripper = new PDFTextStripper();
                String text = stripper.getText(document); // 获取全部文本内容[reference:0]
//            System.out.println( text);
                // 使用 Hutool 的 ReUtil 从文本中提取所有匹配的金额
                String[] split = text.split("\r\n");
                for (String line : split) {
                    try {
                        if (line.contains("元") || line.contains("重庆市")) {
                            if(!line.contains("行程人手机号")){
                                System.out.println(line);

                            }
                        }

//                    System.out.println(numStr);
                    } catch (NumberFormatException ignored) {
                        // 忽略无法解析的数字
                    }
                }
            } catch (IOException e) {
                System.err.println("读取 PDF 文件失败：" + e.getMessage());
            }
        }
    }


}
