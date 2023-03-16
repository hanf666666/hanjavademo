package com.map.maptest01;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *  此实现了线程安全 前提先 初始化数据
 * @author Hj
 * @date 2023/3/15
 */
public class StatisticsUtils3 {
    public static ConcurrentHashMap<String, AtomicInteger> concurrentHashMap = new ConcurrentHashMap();
    public volatile static AtomicInteger countAtomicInteger = null;

    public static void addIncrement(String tableName) {
        AtomicInteger atomicInteger = concurrentHashMap.get(tableName);
//        System.out.println(atomicInteger);

        atomicInteger.getAndIncrement();

    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("aaaaaaaaaaaa=======>1000000");
        for (int f = 0; f < 50; f++) {
            concurrentHashMap.put("aaaaaaaaaaaa", new AtomicInteger(0));
//            System.out.println(concurrentHashMap);
            ExecutorService executorService = Executors.newFixedThreadPool(100);
            ArrayList<Future> futureArrayList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                futureArrayList.add(
                        executorService.submit(() -> {
                            for (int j = 0; j < 10000; j++) {
                                StatisticsUtils3.addIncrement("aaaaaaaaaaaa");
                            }

                        })

                );

            }
            // 等待
            futureArrayList.forEach(future -> {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
//            System.out.println(concurrentHashMap.size());
            concurrentHashMap.forEach((k, v) -> {
                System.out.println(k + "=======>" + v.get());


            });

        }


    }

}
