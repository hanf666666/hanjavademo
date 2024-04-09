package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 * ��Ѷ��redisת����
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateRedisprodDemo {
    public static void main(String[] args) {

//        String srcFileName="application-txdev.properties";
//        String srcFileName="application-txtest.properties";
//        String srcFileName3 = "application-txpre.properties";
        String srcFileName4="application-txprod.properties";

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\yun\\meisoo-appmanage-activity-service\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-order\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (
//                        pathname.getName().indexOf(srcFileName) > -1
                        pathname.getName().indexOf(srcFileName4) > -1
//                ||pathname.getName().indexOf(srcFileName4) > -1
                ) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
            List<String> newContentList = new ArrayList<>();
            try {
                BufferedReader reader = FileUtil.getUtf8Reader(file.toPath());
                String line=null;
                while ((line = reader.readLine()) != null) {
                    // ����ÿһ������
             String updatedContent = null;
//                    //redis
//                    updatedContent = line.replace("10.50.255.23","r-2ze3cb178c631624.redis.rds.aliyuncs.com");
//                    updatedContent = updatedContent.replace("spring.redis.password=ZDzNIwcG8wVCkeO1","spring.redis.password=DyhkQazBs989");
//                    updatedContent = updatedContent.replace("redisson.password=ZDzNIwcG8wVCkeO1","redisson.password=DyhkQazBs989" );


                    //���ﻻtx
                    updatedContent = line.replace("r-2ze3cb178c631624.redis.rds.aliyuncs.com","10.50.255.23");
                    updatedContent = updatedContent.replace("spring.redis.password=DyhkQazBs989","spring.redis.password=ZDzNIwcG8wVCkeO1");
                    updatedContent = updatedContent.replace("redisson.password=DyhkQazBs989","redisson.password=ZDzNIwcG8wVCkeO1" );




                    newContentList.add(updatedContent);
                }
                FileUtil.writeUtf8Lines(newContentList, file);

                // �����ݽ����޸�
            } catch (Exception e) {
                System.out.println(file.getPath());
                e.printStackTrace();
            }
        }
    }
}
