package com.date.main;

import com.date.utils.ConvertEncodetype;
import com.date.utils.TraversalUtil;

import java.io.File;

/**
 * to do
 * 所有项目统一用utf-8
 * @author Hj
 * @date 2021/12/16
 */
public class demo01 {
    public static void main(String[] args) {
       /* final String[] fileArray = {
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\Annotationdemo\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\CharsetGBK_UTF8\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\Connectiondemo\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\DateAndJSONDemo\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\genericparadigmAndReflex\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\hbasedemo\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\hbasedemo2\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\javaDesignPattern\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\java数据结构\\shujujiegou\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\jdk18newsfeatures\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\JVMunderstard\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\logbackdemo\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\MultithreadingDemo\\src\\main",
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo5\\mvnClean\\src\\main",
        };*/
        final String[] fileArray = {
                "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo4\\CharsetGBK_UTF8\\src\\main\\java\\com\\date\\data2",
                };

        try {
            for (String file : fileArray) {
                TraversalUtil.listDirectory(new File(file), ConvertEncodetype.TOUTF);
//            TraversalUtil.listDirectory(new File(file), ConvertEncodetype.TOGBK);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
