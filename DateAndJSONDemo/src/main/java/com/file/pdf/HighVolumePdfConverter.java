package com.file.pdf;

/**
 * @author Hj
 * @date 2025/9/28
 */

import cn.hutool.core.date.StopWatch;
import com.lowagie.text.pdf.PdfDocument;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HighVolumePdfConverter {
    private final ExecutorService executor;
    private final int batchSize;

    public HighVolumePdfConverter(int threadCount, int batchSize) {
        this.executor = Executors.newFixedThreadPool(threadCount);
        this.batchSize = batchSize;
    }


    private static void processSinglePdf(String pdfPath, String outputBaseDir) throws IOException {
        File pdfFile = new File(pdfPath);
        String pdfName = pdfFile.getName().replace(".pdf", "");
        String outputDir = outputBaseDir + File.separator + pdfName;

        new File(outputDir).mkdirs();

        try (PDDocument document = Loader.loadPDF(new File(pdfPath))) {

            PDFRenderer renderer = new PDFRenderer(document);
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            StopWatch stopwatch = StopWatch.create("id");

            for (int pageNum = 0; pageNum < 100; pageNum++) {
                stopwatch.start("task1");

                BufferedImage image = null; // 适当降低DPI提高速度

                    image = renderer.renderImageWithDPI(pageNum, 30);

                stopwatch.stop();
                stopwatch.start("task2");

                String outputPath = outputDir + File.separator +
                            String.format("%s_%d.png", pdfName, pageNum + 1);
                    ImageIO.write(image, "PNG", new File(outputPath));
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ImageIO.write(image, "PNG", baos);
//                return baos.toByteArray();
                stopwatch.stop();
            }
            System.out.println(stopwatch.prettyPrint(TimeUnit.MILLISECONDS));

        }
    }

    public static void main(String[] args)  {
        try {

            processSinglePdf("C:\\Users\\Administrator\\Desktop\\bbb\\sign_lawyer-letters_p20250926141805769.pdf","C:\\Users\\Administrator\\Desktop\\bbb\\cc");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
