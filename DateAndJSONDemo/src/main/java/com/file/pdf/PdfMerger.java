/*
package com.file.pdf;

*/
/**
 * @author Hj
 * @date 2025/9/16
 *//*


import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PdfMerger {
    public static void main(String[] args) {
        String outputPath = "C:\\Users\\Administrator\\Desktop\\meisoocity\\merged.pdf";
        String[] inputFiles = {
                "C:\\Users\\Administrator\\Desktop\\meisoocity\\aaaa.pdf",
                "C:\\Users\\Administrator\\Desktop\\meisoocity\\aaaa.pdf",
                "C:\\Users\\Administrator\\Desktop\\meisoocity\\aaaa.pdf",
                "C:\\Users\\Administrator\\Desktop\\meisoocity\\aaaa.pdf",
        };

        try {
            mergePDFs(inputFiles, outputPath);
            System.out.println("PDFs merged successfully!");
        } catch (IOException e) {
            System.err.println("Error merging PDFs: " + e.getMessage());
        }
    }

    private static void mergePDFs(String[] inputPaths, String outputPath) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();

        for (String path : inputPaths) {
            try (PDDocument doc = PDDocument.load(new File(path))) {
                merger.addSource(new File(path));
            }
        }

        merger.setDestinationFileName(outputPath);
        merger.mergeDocuments(null);
    }
}
*/
