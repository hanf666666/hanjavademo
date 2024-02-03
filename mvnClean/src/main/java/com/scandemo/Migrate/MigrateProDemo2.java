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
public class MigrateProDemo2 {
    public static void main(String[] args) {

        String srcFileName="application-yun.properties";
        String dedfileName="application-txprod.properties";
        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//            List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
                List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-activities\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
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
                        // 修改每一行的内容，这里只是一个简单的示例，你可以根据需要进行修改
                        String modifiedLine = line.replace("fasdfasdfasdfasd", "fasdfasdfasdfasd");
//                         modifiedLine = line.replace("mysql-service.dev.svc.cluster.local", "10.50.254.22");
                        //mysql
                        modifiedLine = modifiedLine.replace("rm-2ze1u8696xk73k9o2.mysql.rds.aliyuncs.com", "10.50.255.15:3306");

                        //mongo 预发都是腾讯云,生产除了redis,mongodb,hbase,都是腾讯云
//                        modifiedLine = modifiedLine.replace("mongodb://db_log:l3W!Fh!8TNwQ@dds-2ze2ce8dce5181b433290.mongodb.rds.aliyuncs.com:3717/db_log", "mongodb://db_log:kuYk1Sp#k5pCP8E!@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/db_log?replicaSet=cmgo-elcc0tif_0&authSource=admin");
//                        modifiedLine = modifiedLine.replace("mongodb://db_log:l3W!Fh!8TNwQ@dds-2ze2ce8dce5181b433290.mongodb.rds.aliyuncs.com:3717/db_log", "mongodb://db_log:kuYk1Sp#k5pCP8E!@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/db_log?replicaSet=cmgo-elcc0tif_0&authSource=admin");

                        //redis 预发都是腾讯云,生产除了redis,mongodb,hbase,都是腾讯云

//                        modifiedLine = modifiedLine.replace("r-2ze3cb178c631624.redis.rds.aliyuncs.com", "10.50.255.23");
//                        modifiedLine = modifiedLine.replace("spring.redis.password=DyhkQazBs989", "spring.redis.password=ZDzNIwcG8wVCkeO1");
//                        modifiedLine = modifiedLine.replace("redisson.password=DyhkQazBs989", "spring.redis.password=ZDzNIwcG8wVCkeO1");

                        //kafka
                        modifiedLine = modifiedLine.replace("172.17.134.26:9092,172.17.134.27:9092,172.17.134.28:9092", "10.50.255.28:9092");

                        //file.store.default.upload.type TencentCOS
                        if(line.contains("file.store.default.upload.type")){
                            modifiedLine ="file.store.default.upload.type=TencentCOS";
                        }

//                        modifiedLine = modifiedLine.replace("spring.datasource.username=meisooWr", "spring.datasource.username=root");
//                        modifiedLine = modifiedLine.replace("spring.datasource.primary.username=mslc", "spring.datasource.primary.username=root");
//                        modifiedLine = modifiedLine.replace("spring.datasource.primary.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.primary.password=password");
//                        modifiedLine = modifiedLine.replace("spring.datasource.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.password=password");
//                         modifiedLine = modifiedLine.replace("eureka-0.eureka.dev.svc.cluster.local", "eureka-0.eureka.dev.svc.cluster.local");
                        writer.write(modifiedLine);
                        writer.newLine(); // 写入一个新行
                    }
                    System.out.println("文件修改成功！");
                } catch (IOException e) {
                    System.err.println("文件修改失败: " + e.getMessage());
                }
            }



        }
    }
}
