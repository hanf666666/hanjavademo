package com.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/16
 */
public class demo {
    public static void main(String[] args) {
        System.out.println(170496/2048);
        System.out.println(349696/170496);
        Long m=1*1024*1024L;
//        K
        System.out.println("计算数据占用总的大小"+(170496*1024L)/m+"M");
        System.out.println("计算数据占用总的大小"+((170496+349696)*1024L)/m+"M");


        HashMap<String, String> stringStringHashMap = new HashMap<>();
        Map<Object, Object> objectObjectConcurrentMap = new ConcurrentHashMap<>();
        objectObjectConcurrentMap.put("asdfa",null);
    }
}
