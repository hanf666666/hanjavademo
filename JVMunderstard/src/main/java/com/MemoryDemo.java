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
        String hanjing = "1a韩静";
        System.out.println(hanjing.getBytes().length);
        Long m=1*1024*1024L;
        System.out.println(m);
        System.out.println(1000000000*11L);
        System.out.println("=======计算数据占用总的大小=======================================>");
        //这么多字节换算为m
        System.out.println("计算数据占用总的大小"+(1000000000*11L)/m+"M");
        System.out.println("<=======计算数据占用总的大小=======================================");

        System.out.println("=======根据总内存大小计算条数e4就是1万=======================================>");
        //总的数据占用大小
        Long totalMomey=12*m*1024L;
        System.out.println("根据总内存大小计算条数"+(12.41*1024*1024*1024L)/400+"条数据");
        System.out.println("<=======根据总内存大小计算条数=======================================");

        System.out.println("=======根据总内存大小计算每条多少字节=======================================>");
        //总的数据占用大小 单位字节
        Long totalMomey2=12*m*1024L;
        Long rows=40000000L;
        System.out.println("根据总内存大小计算每条"+(totalMomey2)/rows+"字节");
        System.out.println("<=======根据总内存大小计算每条多少字节=======================================");


        new ArrayList<>();



//        数值最大存储计算
        System.out.println(calculate(8*4-1L));


    }
    private static Long calculate(Long n) {
        if (n == 0)
            return 1L;
        return 2L * calculate(n - 1);
    }

}
