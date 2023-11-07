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
public class ScanDemo2 {

    public static void main(String[] args) {

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
        List<File> files = FileUtil.loopFiles("E:\\����\\�̹�����Ƽ�", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
        for (File file : files) {
            List<String> stringList = FileUtil.readLines(file, Charset.defaultCharset());
            HashMap<Integer, String> lineMap = new HashMap<>();
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
                if (line.contains("mobile_app_user")) {
                    lineMap.put(i, line);
                }

                if (lineMap.size() >= 1) {
                    System.out.println(file.getPath());
                    System.out.println(lineMap.get(line));
                    lineMap.clear();
                }

            }

        }

    }


}


