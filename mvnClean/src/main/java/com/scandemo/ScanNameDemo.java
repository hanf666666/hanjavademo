package com.scandemo;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/2/19
 */
public class ScanNameDemo {


    public static void main(String[] args) {

        //�ݹ����Ŀ¼�Լ���Ŀ¼�е������ļ� ���Լӹ�������
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().indexOf("yaml") > -1 || pathname.getName().indexOf("application") > -1) {
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
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
//                if (line.contains("spring.application.name")) {
                if (!file.getPath().contains("meisoo-manage-gateway-server")
                        &&line.contains("MEISOO-CITY-SUPERVICE-PLAT-SERVICE")) {
                    System.out.println(file.getPath());
                    System.out.println(line);
                }

            }

        }


    }


}
