package com.map.maptest01;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/16
 */
public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        Integer count=0;
        String key="name";
        concurrentHashMap.put("aaa",count);
        for (int i = 0; i <10000 ; i++) {
            count++;
            concurrentHashMap.put(key,count);
            System.out.println(key+":"+concurrentHashMap.get(key));
            System.out.println(count);

        }
    }
}
