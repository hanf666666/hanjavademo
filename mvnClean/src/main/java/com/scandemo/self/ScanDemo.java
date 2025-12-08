package com.scandemo.self;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemo {

    public static void main(String[] args) {

//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\zijidemo\\springboot_Set", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getPath().indexOf(".git") > -1
                        || pathname.getPath().indexOf("sql") > -1
                        || pathname.getPath().indexOf("target") > -1
                        || pathname.getPath().indexOf(".idea") > -1
//                        || pathname.getPath().indexOf("application") > -1
//                        || pathname.getPath().indexOf("java") > -1
//                        || pathname.getPath().indexOf(".java") > -1
//                        || pathname.getPath().indexOf("txprod") == -1

                ) {
                    {
                        return false;
                    }

                }
                return true;
            }
        });
        for (File file : files) {
//            List<String> stringList = FileUtil.readLines(file, Charset.defaultCharset());
            List<String> stringList = FileUtil.readLines(file, "UTF-8");
            HashMap<Integer, String> lineMap = new HashMap<>();
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
                if ( line.contains("@Async")) {
                    lineMap.put(i, line);
                }

                if (lineMap.size() >= 1) {
                    System.out.println(file.getPath());
                    System.out.println(lineMap.get(i));
                    lineMap.clear();
                }

            }

        }

    }


}


