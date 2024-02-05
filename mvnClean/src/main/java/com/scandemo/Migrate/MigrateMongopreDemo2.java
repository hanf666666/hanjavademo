package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 * 腾讯云redis转阿里
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateMongopreDemo2 {
    public static void main(String[] args) {

//        String srcFileName="application-txdev.properties";
//        String srcFileName="application-txtest.properties";
        String srcFileName3 = "application-txpre.properties";
//        String srcFileName4="application-txprod.properties";

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
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
                        pathname.getName().indexOf(srcFileName3) > -1
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
                    // 处理每一行内容
                    if(line.contains("pksm3i0f_0")){
                        System.out.println(file.getPath());
                    }
                    String updatedContent = null;
                    updatedContent = line.replace( "mongodb://db_log:l3W!Fh!8TNwQ@10.50.254.110:27017,10.50.254.39:27017,10.50.254.143:27017/db_log?authSource=admin&replicaSet=cmgo-pksm3i0f_0","mongodb://db_log:Jj89757***@dds-2ze2242abf52143433270.mongodb.rds.aliyuncs.com:3717/db_log");
                    updatedContent = updatedContent.replace("mongodb://clearing_plat_user:CwQ5yCWpLP@10.50.254.110:27017,10.50.254.39:27017,10.50.254.143:27017/clearing_plat?replicaSet=cmgo-pksm3i0f_0&authSource=admin","mongodb://clearing_plat_user:CwQ5yCWpLP@dds-2ze2242abf52143433270.mongodb.rds.aliyuncs.com:3717/clearing_plat");

                    newContentList.add(updatedContent);
                }
                FileUtil.writeUtf8Lines(newContentList, file);

                // 对内容进行修改
            } catch (Exception e) {
                System.out.println(file.getPath());
                e.printStackTrace();
            }
        }
    }
}
