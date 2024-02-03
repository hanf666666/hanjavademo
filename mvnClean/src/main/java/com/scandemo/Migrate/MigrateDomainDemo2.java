package com.scandemo.Migrate;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/9
 */
public class MigrateDomainDemo2 {
    public static void main(String[] args) {


        String srcFileName3="application-txpre.properties";


        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\ClearingPlat\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java\\yun\\meisoo-appmanage-activity-service\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\backend-java\\meitian-order\\", new FileFilter() {
            //        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\acquisition-platform\\", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji\\java-bj\\BossManage\\meisoo-bossmanage-service\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf(srcFileName3) > -1

                ) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
            List<String> contentList = null;
            try {
                contentList = Files.readAllLines(file.toPath());
                contentList.forEach(line->{
                    if (line.contains("http://beta")) {
                        System.out.println(file.getPath() + " === " + line);
                    }
                });
                // 对内容进行修改
            } catch (Exception e) {
                System.out.println(file.getPath());
              e.printStackTrace();
            }
        }
    }
}
