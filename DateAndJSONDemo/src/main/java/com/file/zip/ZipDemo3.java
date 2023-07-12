package com.file.zip;

import cn.hutool.core.util.ZipUtil;

import java.io.File;

/**
 * to do
 *
 * @author Hj
 * @date 2023/7/3
 */
public class ZipDemo3 {
    public static void main(String[] args) {

       String fileName= "D:\\demo\\310066030013000289863_20430101.zip";

        //将test.zip解压到e:\\aaa目录下，返回解压到的目录
        File unzip = ZipUtil.unzip(fileName, "D:\\/demo2/");


    }
}
