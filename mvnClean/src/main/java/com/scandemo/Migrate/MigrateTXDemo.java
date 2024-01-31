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
public class MigrateTXDemo {
    public static void main(String[] args) {

        String srcFileName = "application-txtest.properties";
        String srcFileName2 = "application-txprod.properties";

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\yun\\meisoo-appmanage-activity-service\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf(srcFileName) > -1 || pathname.getName().indexOf(srcFileName2) > -1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {

            try (BufferedReader reader = new BufferedReader(new FileReader(file))
            ) {

                String line;
                while ((line = reader.readLine()) != null) {
                    // �޸�ÿһ�е����ݣ�����ֻ��һ���򵥵�ʾ��������Ը�����Ҫ�����޸�

                    //file.store.default.upload.type TencentCOS
                    if (line.contains("AliOss")) {
                        System.out.println(file.getPath()+" === "+line);
                    }


                }
            } catch (IOException e) {
                System.err.println("�ļ��޸�ʧ��: " + e.getMessage());
            }
        }


    }
}

