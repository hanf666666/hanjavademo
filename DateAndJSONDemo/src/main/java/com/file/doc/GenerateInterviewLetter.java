package com.file.doc;

/**
 * @author Hj
 * @date 2026/9/9
 */


import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.Paragraph;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateInterviewLetter {
    public static void main(String[] args) throws IOException {
        List<String> docList = new ArrayList<>();
        docList.add("武汉");


        docList.forEach((k -> {
            // 1. 定义替换内容
            Map<String, String> replacements = new HashMap<>();
//  replacements.put("姓名", "韩静");
//  replacements.put("岗位", "大数据开发工程师");
//  replacements.put("原城市", "重庆");
//  replacements.put("电话", "19163154356");
//  replacements.put("日期", "2026年9月9日");
            replacements.put("目标地点：重庆", "\t\t\t\t\t\t\t \t目标地点：" + k + "");
            // 2. 执行替换
            String templatePath = "G:\\学习资料\\aaaa\\czbk2\\大数据\\面试宝典\\简历\\简历大数据\\可用版本\\202610\\韩静-男-8年-大数据开发工程师原版202610.docx";
            String outputPath = "G:\\学习资料\\aaaa\\czbk2\\大数据\\面试宝典\\简历\\简历大数据\\可用版本\\202610\\韩静-男-8年-大数据开发工程师"+ k +"202610.pdf";
            try {
                DocxTemplateReplacer.replaceAndSaveAsPdf(templatePath, outputPath, replacements);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("新文档已生成：" + outputPath);
        }));

    }
}
