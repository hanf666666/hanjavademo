package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 * ?????redis?????
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateMongoprodDemo2 {
    public static void main(String[] args) {

//        String srcFileName="application-txdev.properties";
//        String srcFileName="application-txtest.properties";
//        String srcFileName3 = "application-txpre.properties";
        String srcFileName4="application-txprod.properties";

        //????????????????ß÷???????? ????????????
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
                    // ????????????
                    if(line.contains("pksm3i0f_0")){
                        System.out.println(file.getPath());
                    }
                    String updatedContent = null;
                    //txªª∞¢¿Ô
//                    updatedContent = line.replace( "mongodb://db_log:kuYk1Sp#k5pCP8E!@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/db_log?replicaSet=cmgo-elcc0tif_0&authSource=admin","mongodb://db_log:l3W!Fh!8TNwQ@dds-2ze2ce8dce5181b433290.mongodb.rds.aliyuncs.com:3717/db_log");
//                    updatedContent = updatedContent.replace("mongodb://clearing_plat_user:0NeaEjjEdqTuot@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/clearing_plat?replicaSet=cmgo-elcc0tif_0&authSource=admin","mongodb://clearing_plat_user:CwQ5yCWpLP@dds-2ze2ce8dce5181b433290.mongodb.rds.aliyuncs.com:3717/clearing_plat");
//
                    //∞¢¿Ôªªtx
                    updatedContent = line.replace( "mongodb://db_log:l3W!Fh!8TNwQ@dds-2ze2ce8dce5181b433290.mongodb.rds.aliyuncs.com:3717/db_log","mongodb://db_log:kuYk1Sp#k5pCP8E!@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/db_log?replicaSet=cmgo-elcc0tif_0&authSource=admin");
                    updatedContent = updatedContent.replace("mongodb://clearing_plat_user:CwQ5yCWpLP@dds-2ze2ce8dce5181b433290.mongodb.rds.aliyuncs.com:3717/clearing_plat","mongodb://clearing_plat_user:0NeaEjjEdqTuot@10.50.255.49:27017,10.50.255.21:27017,10.50.255.45:27017/clearing_plat?replicaSet=cmgo-elcc0tif_0&authSource=admin");


                    newContentList.add(updatedContent);
                }
                FileUtil.writeUtf8Lines(newContentList, file);

                // ????????????
            } catch (Exception e) {
                System.out.println(file.getPath());
                e.printStackTrace();
            }
        }
    }
}
