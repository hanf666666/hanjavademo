package com;

import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2022/6/26
 */
public class MemoryDemo {
    public static void main(String[] args) {
        String hanjing = "1a����";
        System.out.println(hanjing.getBytes().length);
        Long m=1*1024*1024L;
        System.out.println(m);
        System.out.println(1000000000*11L);
        //��ô���ֽڻ���Ϊm
        System.out.println((1000000000*11L)/m+"M");

        System.out.println((100*6*30*10000L)/m+"M");

        new ArrayList<>();








    }
}
