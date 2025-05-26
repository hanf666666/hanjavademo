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
public class pomxmlDemo {

    public static void main(String[] args) {

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf("pom.xml") > -1 ) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        for (File file : files) {
            List<String> stringList = FileUtil.readLines(file, Charset.defaultCharset());
//            stringList.parallelStream().forEach(line->{
//                if(line.contains("opo.occupy_order_id IS NULL")){
//                    System.out.println(file.getPath());
//                    System.out.println(line);
//                }
//
//            });
            HashMap<Integer, String> lineMap = new HashMap<>();
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
//                if (line.contains("com.baomidou")) {
//                    lineMap.put(i,line);
//                }
//                if (line.contains("mybatis-plus-boot-starter")) {
//                    lineMap.put(i,line);
//                }
                if (line.contains("spring-boot")) {
                    lineMap.put(i, line);
                }
                if (line.contains("2.7")) {
                    lineMap.put(i, line);
                }

                if(lineMap.size()>=2){
                    Object[] keys = lineMap.keySet().toArray();
                    if(Math.abs((Integer) keys[0]-(Integer)(keys[1]))<15){
                        System.out.println(file.getPath());
                        System.out.println(lineMap.get(keys[0]));
                        System.out.println(lineMap.get(keys[1]));
                        lineMap.clear();
                    }

                }

            }

        }


    }


}
