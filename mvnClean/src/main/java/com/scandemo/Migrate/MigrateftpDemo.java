package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateftpDemo {
    public static void main(String[] args) {

        String srcFileName = "application-yun.properties";
        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
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
            try (BufferedReader reader = new BufferedReader(new FileReader(file)); ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("ftp")) {
                        System.out.println(file.getPath() + " === " + line);
                    }
                }
                System.out.println("�ļ��޸ĳɹ���");
            } catch (IOException e) {
                System.err.println("�ļ��޸�ʧ��: " + e.getMessage());
            }


        }
    }

}
