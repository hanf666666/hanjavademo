package com.map.maptest01;

import java.util.concurrent.ConcurrentHashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/16
 */
public class Main2 {
    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        Integer count=0;
        String key="name";
        concurrentHashMap.put(key,count);
        for (int i = 0; i <10000 ; i++) {
            addIncrement(key);
        }
        System.out.println(concurrentHashMap.get(key));
    }

    public static void addIncrement(String tableName) {
        //StatisticsUtils4.concurrentHashMap.get(tableName) 将拿不到值 因为这是Main2
        //Main2.concurrentHashMap.get(tableName)
        //改为concurrentHashMap.get(tableName)
        Integer count  = concurrentHashMap.get(tableName);
        if (count == null) {
            synchronized (StatisticsUtils4.class) {
                count  = concurrentHashMap.get(tableName);
                if (count == null) {
                    count = 0;
                    count=count+1;
                    concurrentHashMap.put(tableName, count);


                } else {
                    count=count+1;
                    concurrentHashMap.put(tableName, count);


                }
            }
        } else {
            count=count+1;
            concurrentHashMap.put(tableName, count);

        }

    }
}
