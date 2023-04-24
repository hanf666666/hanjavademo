package com.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * to do
 * mat 的单位是字节
 * @author Hj
 * @date 2022/7/16
 */
public class ClassMemeryDemo {
    public static void main(String[] args) {

        //这么多字节
        Long classMemery=4+20L;
        Long count=164331L;
        System.out.println(349696/170496);
        Long m=1*1024*1024L;
//        400w
        System.out.println("计算数据占用总的大小"+(classMemery*count)/m+"M");
        System.out.println("计算数据占用总的大小"+(classMemery*count)+"bytes");

    }
}
