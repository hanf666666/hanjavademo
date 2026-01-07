package com.scandemo.meitikeji;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;

/**
 * ²é°æ±¾
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemo1 {

    public static void main(String[] args) {

//        String line2 = " parkOrder.setStatus(OrderStatusEnum.PAID.getValue());";
//        if (
//                line2.contains("parkOrder.setStatus(")
//                        && (line2.contains("OrderStatusEnum.PAID") || line2.contains("3"))
////                        &&(file.getPath().contains("road"))
//
//
//        ) {
//            System.out.println(line2);
//        }


//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getPath().indexOf(".git") > -1
                        || pathname.getPath().indexOf("sql") > -1
                        || pathname.getPath().indexOf("target") > -1
                        || pathname.getPath().indexOf(".idea") > -1
                        || pathname.getPath().indexOf(".java") > -1
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
            int lineNum = 0;
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
                if (line.contains("spring-boot-dependencies") || line.contains("spring-boot.version")) {
                    lineNum++;
                }

                if (lineNum >= 1 && lineNum <= 5) {
                    if(lineNum==1){
                        System.out.println(file.getPath());
                    }
                    System.out.println(line);
                    lineNum++;

                }else {
                    lineNum=0;
                }

            }

        }

    }


}


