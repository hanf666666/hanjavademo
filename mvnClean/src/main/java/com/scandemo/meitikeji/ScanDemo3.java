package com.scandemo.meitikeji;

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
public class ScanDemo3 {

    public static void main(String[] args) {

        //递归遍历目录以及子目录中的所有文件 可以加过滤条件
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("E:\\资料\\盘古美天科技\\20220920封闭平台\\20220922yum3.0\\2024061102处理6月1号数据和重复在停\\", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
        for (File file : files) {
//            List<String> stringList = FileUtil.readLines(file, Charset.defaultCharset());
            List<String> stringList = FileUtil.readLines(file, "UTF-8");
            HashMap<Integer, String> lineMap = new HashMap<>();
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
                if (line.contains("\"CAR_IN\"") ) {
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


