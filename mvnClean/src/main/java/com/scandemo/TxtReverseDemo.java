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
public class TxtReverseDemo {

    public static void main(String[] args) {

        List<String> stringList = FileUtil.readLines("C:\\Users\\Administrator\\Desktop\\bbb\\log.txt", Charset.defaultCharset());
        for (int i = stringList.size()-1; i >0; i--) {
            System.out.println(stringList.get(i));

        }


    }


}
