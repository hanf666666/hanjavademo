package com.date.utils;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */

import java.io.File;
import java.io.IOException;

//列出File的一些常用操作
public class TraversalUtil {
    /**
     * 遍历指定目录下（包括其子目录）的所有文件，并删除以 lastUpdated 结尾的文件
     *
     * @param dir 目录的位置 path
     * @throws IOException
     */
    public static void listDirectory(File dir, ConvertEncodetype convertEncodetype) throws IOException {
        if (!dir.exists())
            throw new IllegalArgumentException("目录：" + dir + "不存在.");
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是目录。");
        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory())
                    //递归
                    listDirectory(file, convertEncodetype);
                else { // 删除以 lastUpdated 结尾的文件
                    String fileName = file.getName();
                    System.out.println(file.getParent() + fileName);
                    String file1 = file.getParent() + "\\" + fileName;
                    //推测的编码类型
                    String encodetype = EncodeUtils.getFileEncoding(file1);
                    if (encodetype.contains("UTF-8") && convertEncodetype == ConvertEncodetype.TOGBK) {
                        //转为gbk
                        System.out.println("源文件类型===>" + encodetype + "===>将转为gbk");
                        EncodeUtils.handleCharsetUTF8ToGBK(file1, file1);
                    } else if (encodetype.contains("UTF-8") && convertEncodetype == ConvertEncodetype.TOUTF) {
                        System.out.println("本身就是UTF-8,不需要再转");
                    } else if (encodetype.contains("GB2312") && convertEncodetype == ConvertEncodetype.TOUTF) {
                        //转为utf
                        System.out.println("源文件类型===>" + encodetype + "===>将转为UTF8");
//                        EncodeUtils.handleCharsetGBKToUTF8(file1, file1);

                    } else if (encodetype.contains("GB2312") && convertEncodetype == ConvertEncodetype.TOGBK) {
                        System.out.println("本身就是GB2312,不需要再转");
                    } else {
                        System.out.println("源文件类型===>" + encodetype + "===>不变????????????????");

                    }
                }
            }
        }
    }


}
