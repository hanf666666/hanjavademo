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

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("E:\\����\\�̹�����Ƽ�\\20220920���ƽ̨\\20220922yum3.0\\2024061102����6��1�����ݺ��ظ���ͣ\\", new FileFilter() {
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


