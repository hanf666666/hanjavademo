package com.scandemo;

import cn.hutool.core.io.BufferUtil;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemo {

    public static void main(String[] args) {

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
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
                if (line.contains("update order_third_detail set")) {
                    lineMap.put(i,line);
                }
                if (line.contains("trade_no in")) {
                    lineMap.put(i,line);
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
