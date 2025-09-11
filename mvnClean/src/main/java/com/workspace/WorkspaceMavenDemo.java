package com.workspace;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2025/9/10
 */
public class WorkspaceMavenDemo {
    public static void main(String[] args) {

        String srcFileName="workspace.xml";
        String dedfileName="workspace2.xml";
        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//            List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-activities\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf(srcFileName) > -1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {


            Path source = Paths.get(file.getPath());
            Path destination = Paths.get(file.getParent()+"//"+dedfileName);
//            destination.toFile().delete();
//            destination = Paths.get(file.getParent()+"//"+dedfileName);
            try {
                System.out.println(file.getPath());
                System.out.println(file.getParent());
                Files.copy(source, destination);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }finally {
                File sourceFile =source.toFile();
                File destinationFile = destination.toFile();

                try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // 修改每一行的内容，这里只是一个简单的示例，你可以根据需要进行修改
                        String modifiedLine = line.replace("C:\\maven\\apache-maven-3.6.3\\conf\\settings-mt.xml", "E:\\maven\\apache-maven-3.3.9\\conf\\settings-mtwl.xml");
                         modifiedLine = modifiedLine.replace("C:\\Users\\Administrator\\.m2\\settings.xml", "E:\\maven\\apache-maven-3.3.9\\conf\\settings-mtwl.xml");

                         modifiedLine = modifiedLine.replace("C:\\maven\\apache-maven-3.6.3", "E:\\maven\\apache-maven-3.3.9");

                         modifiedLine = modifiedLine.replace("C:\\maven\\maven_store", "E:\\maven\\Maven_Repositorydashuju4");
                         modifiedLine = modifiedLine.replace("C:\\maven\\maven_store", "E:\\maven\\Maven_Repositorydashuju4");
//                         modifiedLine = line.replace("mysql-service.dev.svc.cluster.local", "10.50.254.22");
                           writer.write(modifiedLine);
                        writer.newLine(); // 写入一个新行
                    }
                    sourceFile.delete();
//                    destinationFile.renameTo(sourceFile);
                    System.out.println("文件修改成功！");
                } catch (IOException e) {
                    System.err.println("文件修改失败: " + e.getMessage());
                }
            }



        }

    }
    public static void modifyFile(String filePath, String content, boolean append) {
        try {
            Path path = Paths.get(filePath);
            if (append) {
                // 追加内容
                Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
            } else {
                // 覆盖内容
                Files.write(path, content.getBytes());
            }
            System.out.println("文件修改成功！");
        } catch (IOException e) {
            System.err.println("错误: " + e.getMessage());
        }
    }
}
