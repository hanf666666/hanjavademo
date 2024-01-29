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
public class MigrateTestDemo {
    public static void main(String[] args) {
      String srcFileName="application-k8stest1.properties";
      String dedfileName="application-txtest.properties";
        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\yun\\meisoo-appmanage-activity-service\\", new FileFilter() {
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
//                         modifiedLine = modifiedLine.replace("mysql-service.dev.svc.cluster.local", "10.50.254.22");

                        //mongo
                        modifiedLine = modifiedLine.replace("spring.data.mongodb.uri=mongodb://mongo-svc.test1.svc.cluster.local:27017/log_db", "spring.data.mongodb.uri=mongodb://db_log:Cb6JFb5HNt@@U2A*@mongo-svc.test.svc.cluster.local:27018/db_log");
                        modifiedLine = modifiedLine.replace("test1", "test");

//                         modifiedLine = modifiedLine.replace("mongo-svc.dev.svc.cluster.local", "10.50.254.22");

                        //redis
                         modifiedLine = modifiedLine.replace("spring.redis.port=6379", "spring.redis.port=16379");

                         //kafka
                         modifiedLine = modifiedLine.replace("kafka-service.test1.svc.cluster.local:9092", "kafka-service.test.svc.cluster.local:19092");

                        //mysql
                        if(modifiedLine.contains("spring.datasource.username")){
                            modifiedLine = "spring.datasource.username=root";
                        }
                        if(modifiedLine.contains("spring.datasource.password")){
                            modifiedLine = "spring.datasource.password=password";
                        }
                        modifiedLine = modifiedLine.replace("spring.datasource.primary.username=mslc", "spring.datasource.primary.username=root");
                        modifiedLine = modifiedLine.replace("spring.datasource.primary.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.primary.password=password");


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
