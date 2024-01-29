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
public class MigrateOSSDemo {
    public static void main(String[] args) {



        String srcFileName = "application-yun.properties";
        String srcFileName2 = ".java";
        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
//                if (true) {
                if (pathname.getName().indexOf(srcFileName) > -1||pathname.getName().indexOf(srcFileName2) > -1) {
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
                    if (line.toLowerCase().contains("accesskey")) {
                        System.out.println(file.getPath() + " === " + line);
                    }
                }

            } catch (IOException e) {
            }


        }
    }
}
