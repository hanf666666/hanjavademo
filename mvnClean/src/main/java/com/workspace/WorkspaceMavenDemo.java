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
        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
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
                        // �޸�ÿһ�е����ݣ�����ֻ��һ���򵥵�ʾ��������Ը�����Ҫ�����޸�
                        String modifiedLine = line.replace("C:\\maven\\apache-maven-3.6.3\\conf\\settings-mt.xml", "E:\\maven\\apache-maven-3.3.9\\conf\\settings-mtwl.xml");
                         modifiedLine = modifiedLine.replace("C:\\Users\\Administrator\\.m2\\settings.xml", "E:\\maven\\apache-maven-3.3.9\\conf\\settings-mtwl.xml");

                         modifiedLine = modifiedLine.replace("C:\\maven\\apache-maven-3.6.3", "E:\\maven\\apache-maven-3.3.9");

                         modifiedLine = modifiedLine.replace("C:\\maven\\maven_store", "E:\\maven\\Maven_Repositorydashuju4");
                         modifiedLine = modifiedLine.replace("C:\\maven\\maven_store", "E:\\maven\\Maven_Repositorydashuju4");
//                         modifiedLine = line.replace("mysql-service.dev.svc.cluster.local", "10.50.254.22");
                           writer.write(modifiedLine);
                        writer.newLine(); // д��һ������
                    }
                    sourceFile.delete();
//                    destinationFile.renameTo(sourceFile);
                    System.out.println("�ļ��޸ĳɹ���");
                } catch (IOException e) {
                    System.err.println("�ļ��޸�ʧ��: " + e.getMessage());
                }
            }



        }

    }
    public static void modifyFile(String filePath, String content, boolean append) {
        try {
            Path path = Paths.get(filePath);
            if (append) {
                // ׷������
                Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
            } else {
                // ��������
                Files.write(path, content.getBytes());
            }
            System.out.println("�ļ��޸ĳɹ���");
        } catch (IOException e) {
            System.err.println("����: " + e.getMessage());
        }
    }
}
