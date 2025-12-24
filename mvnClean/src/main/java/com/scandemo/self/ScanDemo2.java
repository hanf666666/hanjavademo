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
public class ScanDemo2 {

    public static void main(String[] args) {

//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
        List<File> files = FileUtil.loopFiles("C:\\Users\\Administrator\\Desktop\\ddd", new FileFilter() {
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
//           if(file.getName().contains("行程单")){
////               System.out.println(file.getName());
//               String s = file.getName().split("-")[1].split("元")[0];
//               System.out.println(s);
//           }
            if(file.getName().contains("ofd")){
//               System.out.println(file.getName());
//                String s = file.getName().split("-")[1].split("元")[0];
                System.out.println(file.getName());
            }


        }

    }


}


