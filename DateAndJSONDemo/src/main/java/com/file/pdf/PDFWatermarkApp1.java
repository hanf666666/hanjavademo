package com.file.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;

/**
 * @author Hj
 * @date 2025/10/29
 */
public class PDFWatermarkApp1 {
    public static void main(String[] args) throws Exception {
        // 加载原始PDF文档
        PDDocument document = PDDocument.load(new File("C:\\Users\\Administrator\\Desktop\\meisoocity\\bbb.pdf"));

        // 遍历每一页
        for (PDPage page : document.getPages()) {
            // 创建内容流，以APPEND模式添加内容
            try (PDPageContentStream contentStream = new PDPageContentStream(
                    document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {

                contentStream.beginText();
                // 设置字体和大小
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 50);
                // 设置文本颜色 (RGB)，此处为浅灰色
                contentStream.setNonStrokingColor(200, 200, 200);
                // 设定文本起始位置
                contentStream.newLineAtOffset(250, 400);
                contentStream.showText("Confidential"); // 水印文本
                contentStream.endText();
            }
        }
        // 保存添加水印后的PDF
        document.save("output_with_text_watermark.pdf");
        document.close();
    }
}
