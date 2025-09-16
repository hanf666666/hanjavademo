package com.file.pdf;

/**
 * @author Hj
 * @date 2025/9/16
 */

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfSplitter {
    public static void main(String[] args) {


        String outputPath = "C:\\Users\\Administrator\\Desktop\\meisoocity\\merged.pdf";
        String inputFiles = "C:\\Users\\Administrator\\Desktop\\meisoocity\\";
        int splitCount = 4;

        try {
            splitPDF(outputPath, inputFiles, splitCount);
            System.out.println("PDF拆分完成！");
        } catch (IOException e) {
            System.err.println("PDF拆分失败: " + e.getMessage());
        }
    }

    private static void splitPDF(String inputPath, String outputPrefix, int splitCount)
            throws IOException {
        try (PDDocument document = PDDocument.load(new File(inputPath))) {
            Splitter splitter = new Splitter();
            splitter.setSplitAtPage(document.getNumberOfPages() / splitCount);

            List<PDDocument> splitDocuments = splitter.split(document);

            for (int i = 0; i < splitDocuments.size(); i++) {
                String outputPath = outputPrefix + (i + 1) + ".pdf";
                System.out.println(outputPath);
                splitDocuments.get(i).save(outputPath);
                splitDocuments.get(i).close();
            }
        }
    }
}

