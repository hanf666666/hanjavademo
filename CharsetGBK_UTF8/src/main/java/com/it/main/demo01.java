package com.it.main;

import com.it.utils.EncodeUtils;

import java.io.File;
import java.io.IOException;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/16
 */
public class demo01 {
    public static void main(String[] args) {
        final File file1 = new File("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\CharsetGBK_UTF8\\src\\main\\java\\com\\it\\main\\BubbleSort.java");
        final File file2 = new File("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\CharsetGBK_UTF8\\src\\main\\java\\com\\it\\main\\BubbleSort2.java");
        final File file3 = new File("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\CharsetGBK_UTF8\\src\\main\\java\\com\\it\\main\\BubbleSort3.java");
//        EncodeUtils.handleCharsetGBKToUTF8(file1,file2);
//        EncodeUtils.handleCharsetUTF8ToGBK(file1,file3);
        try {
           String encodetype1= EncodeUtils.getFileEncoding("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\CharsetGBK_UTF8\\src\\main\\java\\com\\it\\main\\BubbleSort3.java");
           String encodetype2= EncodeUtils.getFileEncode("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\CharsetGBK_UTF8\\src\\main\\java\\com\\it\\main\\BubbleSort3.java");
            System.out.println(encodetype1);
            System.out.println(encodetype2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
