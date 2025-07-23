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
public class MigrateProDemo {
    public static void main(String[] args) {

        String srcFileName="application-txprod.properties";
        String dedfileName="application-sntxprod.properties";
        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\dataCenterService\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\CoreControl\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\yun\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\common_service\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-order\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\meisoo-datasync-service\\", new FileFilter() {
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
                        modifiedLine = modifiedLine.replace("10.50.255.15:3306", "10.50.254.103:3306");

                        //mongo 预发都是腾讯云,生产除了redis,mongodb,hbase,都是腾讯云
                        modifiedLine = modifiedLine.replace( "mongodb://db_log:kuYk1Sp#k5pCP8E!@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/db_log?replicaSet=cmgo-elcc0tif_0&authSource=admin","mongodb://db_log:HfS1zeNsmRIdMSnf@10.50.254.142:27017,10.50.254.129:27017,10.50.254.100:27017/db_log?replicaSet=cmgo-43jij4g5_0&authSource=admin");
//                        modifiedLine = modifiedLine.replace( "mongodb://clearing_plat_user:0NeaEjjEdqTuot@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/clearing_plat?replicaSet=cmgo-elcc0tif_0&authSource=admin");

                        //redis 预发都是腾讯云,生产除了redis,mongodb,hbase,都是腾讯云

                        modifiedLine = modifiedLine.replace( "10.50.255.23","10.50.254.64");
                        modifiedLine = modifiedLine.replace("spring.redis.password=ZDzNIwcG8wVCkeO1","spring.redis.password=kWOq94NtbDbR6m59");
                        modifiedLine = modifiedLine.replace( "spring.redis.password=ZDzNIwcG8wVCkeO1","spring.redis.password=kWOq94NtbDbR6m59");

                        //kafka
                        modifiedLine = modifiedLine.replace("10.50.255.28:9092","10.50.254.127:9092");

                        //file.store.default.upload.type TencentCOS
                        if(line.contains("file.store.default.upload.type")){
                            modifiedLine ="file.store.default.upload.type=TencentCOS";
                        }

                        ////user
                        modifiedLine = modifiedLine.replace("spring.datasource.username=meisooWr", "spring.datasource.username=sn");
                        modifiedLine = modifiedLine.replace("spring.datasource.username=api_deploy", "spring.datasource.username=sn");
                        modifiedLine = modifiedLine.replace("spring.datasource.username=msfb", "spring.datasource.username=sn");
                        modifiedLine = modifiedLine.replace("spring.datasource.username=mszf", "spring.datasource.username=sn");

                        modifiedLine = modifiedLine.replace("spring.datasource.primary.username=mslc", "spring.datasource.primary.username=sn");
                        modifiedLine = modifiedLine.replace("spring.datasource.slave.username=api_deploy", "spring.datasource.slave.username=sn");

                        modifiedLine = modifiedLine.replace("spring.datasource.druid.primary.username=msfb", "spring.datasource.druid.primary.username=sn");
                        modifiedLine = modifiedLine.replace("spring.datasource.druid.secondary.username=api_deploy", "spring.datasource.druid.secondary.username=sn");
                        modifiedLine = modifiedLine.replace("spring.shardingsphere.datasource.master.username=api_deploy", "spring.shardingsphere.datasource.master.username=sn");
                        modifiedLine = modifiedLine.replace("spring.shardingsphere.datasource.slave.username=api_deploy", "spring.shardingsphere.datasource.slave.username=sn");

                        //password
                        modifiedLine = modifiedLine.replace("spring.datasource.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.datasource.password=1qaz@WSX", "spring.datasource.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.datasource.password=FiZTI0ZTE1MTFiOGVlMDMP", "spring.datasource.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.datasource.password=IzNDYwMDI5NTBjNDE3M2QP", "spring.datasource.password=4fhxC5rksvQyZjPb");

                        modifiedLine = modifiedLine.replace("spring.datasource.primary.password=RmNzM2MjNiYmMzMWMwNTMT", "spring.datasource.primary.password=4fhxC5rksvQyZjPb");

                        modifiedLine = modifiedLine.replace("spring.datasource.druid.primary.password=FiZTI0ZTE1MTFiOGVlMDMP", "spring.datasource.druid.primary.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.datasource.druid.secondary.password=1qaz@WSX", "spring.datasource.druid.secondary.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.datasource.slave.password=1qaz@WSX", "spring.datasource.slave.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.shardingsphere.datasource.master.password=1qaz@WSX", "spring.shardingsphere.datasource.master.password=4fhxC5rksvQyZjPb");
                        modifiedLine = modifiedLine.replace("spring.shardingsphere.datasource.slave.password=1qaz@WSX", "spring.shardingsphere.datasource.slave.password=4fhxC5rksvQyZjPb");

                        modifiedLine = modifiedLine.replace("10.50.255.39:3306", "10.50.254.103:3306");

                         modifiedLine = modifiedLine.replace("http://eureka-0.eureka.prod.svc.cluster.local:8761/center/eureka/,http://eureka-1.eureka.prod.svc.cluster.local:8761/center/eureka/,http://eureka-2.eureka.prod.svc.cluster.local:8761/center/eureka/", "http://eureka-0.eureka.test.svc.cluster.local:8761/center/eureka/,http://eureka-1.eureka.test.svc.cluster.local:8761/center/eureka/,http://eureka-2.eureka.test.svc.cluster.local:8761/center/eureka/");
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
