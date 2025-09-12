package com.workspace;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2025/9/10
 */
public class WorkspaceMavenDemo {
    public static void main(String[] args) throws IOException {

        String srcFileName = "workspace.xml";

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//            List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-activities\\", new FileFilter() {
        //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
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

            File sourceFile = source.toFile();
            List<String> lines = Files.readAllLines(source);


            List<String> newlines = new ArrayList<>();

            for (String line : lines) {
                // �޸�ÿһ�е����ݣ�����ֻ��һ���򵥵�ʾ��������Ը�����Ҫ�����޸�
                String modifiedLine = line.replace("C:\\maven\\apache-maven-3.6.3\\conf\\settings-mt.xml", "E:\\maven\\apache-maven-3.3.9\\conf\\settings-mtwl.xml");
                modifiedLine = modifiedLine.replace("C:\\Users\\Administrator\\.m2\\settings.xml", "E:\\maven\\apache-maven-3.3.9\\conf\\settings-mtwl.xml");

                modifiedLine = modifiedLine.replace("C:\\maven\\apache-maven-3.6.3", "E:\\maven\\apache-maven-3.3.91");
                modifiedLine = modifiedLine.replace("E:\\maven\\apache-maven-3.3.91", "E:\\maven\\apache-maven-3.3.9");

                modifiedLine = modifiedLine.replace("C:\\maven\\maven_store", "E:\\maven\\Maven_Repositorydashuju4");
                modifiedLine = modifiedLine.replace("C:\\maven\\maven_store", "E:\\maven\\Maven_Repositorydashuju4");
                newlines.add(modifiedLine);
            }


            // ����д���ļ�������ģʽ��
            Files.write(source, newlines);

            System.out.println("�ļ��޸ĳɹ���");

        }


    }

}


