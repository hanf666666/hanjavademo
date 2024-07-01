package com.scandemo;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemosimple {

    public static void main(String[] args) {

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\", new FileFilter() {
            List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {

                @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf("xml") > -1 || pathname.getName().indexOf("java") > -1) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
//            if(file.getPath().contains("HomeMapper")){
//                System.out.println(file.getPath());
//            }

            List<String> stringList = FileUtil.readLines(file, Charset.defaultCharset());
//            stringList.parallelStream().forEach(line->{
//                if(line.contains("opo.occupy_order_id IS NULL")){
//                    System.out.println(file.getPath());
//                    System.out.println(line);
//                }
//
//            });
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
                if (line.contains("waterBillsRecordRepository.save")) {
                    System.out.println(file.getPath());
                    System.out.println(line);
                }

            }

        }


    }


}
