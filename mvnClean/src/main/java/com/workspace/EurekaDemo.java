package com.workspace;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2025/9/10
 */
public class EurekaDemo {
    public static void main(String[] args) throws IOException {

        String srcFileName = "local.properties";

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//            List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-activities\\", new FileFilter() {
        //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().contains(srcFileName)) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {


            Path source = Paths.get(file.getPath());
            System.out.println(file.getPath());
            File sourceFile = source.toFile();
            List<String> lines =null;

            try {
               lines = Files.readAllLines(source, StandardCharsets.UTF_8);
            } catch (MalformedInputException e) {
                // 使用其他编码重试
                lines = Files.readAllLines(source, Charset.defaultCharset());
            }

            List<String> newlines = new ArrayList<>();

            for (String line : lines) {
                // 修改每一行的内容，这里只是一个简单的示例，你可以根据需要进行修改
//                String modifiedLine = line.replaceAll("http://123.56.13.226:8761", "123.56.13.226:8761");
                String  modifiedLine = line.replaceAll("47.95.216.113:8761", "123.56.13.226:8761");
                 newlines.add(modifiedLine);
            }


            // 重新写入文件（覆盖模式）
            Files.write(source, newlines);

            System.out.println("文件修改成功！");

        }


    }

}


