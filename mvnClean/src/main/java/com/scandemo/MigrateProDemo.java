package com.scandemo;

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
public class MigrateProDemo {
    public static void main(String[] args) {

        String srcFileName="application-yun.properties";
        String dedfileName="application-txprod.properties";
        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
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
            Path source = Paths.get(file.getPath());
            Path destination = Paths.get(file.getParent()+"//"+dedfileName);
            destination.toFile().delete();
            destination = Paths.get(file.getParent()+"//"+dedfileName);
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
                        String modifiedLine = line.replace("fasdfasdfasdfasd", "fasdfasdfasdfasd");
//                         modifiedLine = line.replace("mysql-service.dev.svc.cluster.local", "10.50.254.22");
                        //mysql
                        modifiedLine = modifiedLine.replace("rm-2ze1u8696xk73k9o2.mysql.rds.aliyuncs.com", "10.50.255.15:3306");
                        //mongo
                        modifiedLine = modifiedLine.replace("mongodb://db_log:Jj89757***@dds-2ze2242abf52143433270.mongodb.rds.aliyuncs.com:3717/db_log", "spring.data.mongodb.uri=mongodb://db_log:l3W!Fh!8TNwQ@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/db_log");
                        //redis
                        modifiedLine = modifiedLine.replace("r-2ze3cb178c631624.redis.rds.aliyuncs.com", "10.50.255.23");
                        modifiedLine = modifiedLine.replace("spring.redis.password=DyhkQazBs989", "spring.redis.password=ZDzNIwcG8wVCkeO1");
                        //kafka
                        modifiedLine = modifiedLine.replace("172.17.134.26:9092,172.17.134.27:9092,172.17.134.28:9092", "10.50.254.4:9092");
//                        modifiedLine = modifiedLine.replace("spring.datasource.username=meisooWr", "spring.datasource.username=root");
//                        modifiedLine = modifiedLine.replace("spring.datasource.primary.username=mslc", "spring.datasource.primary.username=root");
//                        modifiedLine = modifiedLine.replace("spring.datasource.primary.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.primary.password=password");
//                        modifiedLine = modifiedLine.replace("spring.datasource.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.password=password");
//                         modifiedLine = modifiedLine.replace("eureka-0.eureka.dev.svc.cluster.local", "eureka-0.eureka.dev.svc.cluster.local");
                        writer.write(modifiedLine);
                        writer.newLine(); // д��һ������
                    }
                    System.out.println("�ļ��޸ĳɹ���");
                } catch (IOException e) {
                    System.err.println("�ļ��޸�ʧ��: " + e.getMessage());
                }
            }



        }
    }
}
