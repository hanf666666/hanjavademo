package com.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * to do
 * mat �ĵ�λ���ֽ�
 * @author Hj
 * @date 2022/7/16
 */
public class ClassMemeryDemo {
    public static void main(String[] args) {

        //��ô���ֽ�
        Long classMemery=4+20L;
        Long count=164331L;
        System.out.println(349696/170496);
        Long m=1*1024*1024L;
//        400w
        System.out.println("��������ռ���ܵĴ�С"+(classMemery*count)/m+"M");
        System.out.println("��������ռ���ܵĴ�С"+(classMemery*count)+"bytes");

    }
}
