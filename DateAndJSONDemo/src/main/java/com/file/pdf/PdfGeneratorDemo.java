package com.file.pdf;

/**
 * @author Hj
 * @date 2025/9/8
 */

import freemarker.template.*;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.*;

public class PdfGeneratorDemo {
    private static final Configuration freemarkerCfg = new Configuration(Configuration.VERSION_2_3_32);

    public static void main(String[] args) throws Exception {
        // 1. ��ʼ��ģ������
        freemarkerCfg.setDirectoryForTemplateLoading(new File("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\src\\main\\resources\\templates"));
        freemarkerCfg.setDefaultEncoding("UTF-8");

        // 2. ׼����̬����
        Map<String, Object> data = new HashMap<>();
        data.put("documentTitle", "��Ʒ�۸��嵥");

        List<Map<String, Object>> products = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "�ʼǱ�����1");
        map1.put("price", 1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "�ʼǱ�����2");
        map2.put("price", 2);
        products.add(map1);
        products.add(map2);
        data.put("products", products);
        data.put("discountApplied", true);

        // 3. ��ȾHTML
        Template template = freemarkerCfg.getTemplate("template.ftl");
        StringWriter htmlWriter = new StringWriter();
        template.process(data, htmlWriter);
        String htmlContent = htmlWriter.toString();
        System.out.println(htmlContent);

        // 4. ����PDF
        try (OutputStream os = new FileOutputStream("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\src\\main\\resources\\templates\\output.pdf")) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(os);
        }

        System.out.println("PDF���ɳɹ���");
    }
}

