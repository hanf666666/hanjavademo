package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateDomainDemo {
    public static void main(String[] args) {

        String srcFileName="application-txdev.properties";
//        String srcFileName="application-txtest.properties";
        String srcFileName3="application-txpre.properties";
        String srcFileName4="application-txprod.properties";

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\yun\\meisoo-appmanage-activity-service\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-order\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf(srcFileName) > -1
                ||pathname.getName().indexOf(srcFileName3) > -1
                ||pathname.getName().indexOf(srcFileName4) > -1
                ) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {

            List<String> contentList = null;
            List<String> newContentList = new ArrayList<>();
            try {
                contentList = Files.readAllLines(file.toPath());
                contentList.forEach(line->{
                    String updatedContent=null;

                    updatedContent = line.replace("http://dev", "http://txdev");
//                     updatedContent = updatedContent.replace("http://test", "http://txdev");
                     updatedContent = updatedContent.replace("http://beta", "http://txbeta");
                     updatedContent = updatedContent.replace("http://api", "http://txapi");

                    newContentList.add(updatedContent);
                });
                // ���޸ĺ������д�ص��ļ���
                Files.write(file.toPath(), newContentList);
                // �����ݽ����޸�
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
