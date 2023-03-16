package com.map.maptest01;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *  为啥出现线程不安全
 * @author Hj
 * @date 2023/3/15
 */
public class StatisticsUtils2 {
    public static ConcurrentHashMap<String, AtomicInteger> concurrentHashMap = new ConcurrentHashMap();

    public static void addIncrement(String tableName) {
         AtomicInteger countAtomicInteger  = StatisticsUtils2.concurrentHashMap.get(tableName);
        if (countAtomicInteger == null) {
            synchronized (StatisticsUtils2.class) {
                if (countAtomicInteger == null) {
                    countAtomicInteger = new AtomicInteger();
                    concurrentHashMap.put(tableName, countAtomicInteger);
                    countAtomicInteger.getAndIncrement();

                } else {
                    countAtomicInteger.getAndIncrement();

                }
            }
        } else {
            countAtomicInteger.getAndIncrement();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("aaaaaaaaaaaa=======>1000000");
        for (int f = 0; f < 2; f++) {
            concurrentHashMap = new ConcurrentHashMap();
            ExecutorService executorService = Executors.newFixedThreadPool(100);
            ArrayList<Future> futureArrayList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                futureArrayList.add(
                        executorService.submit(() -> {
                            for (int j = 0; j < 10000; j++) {
                                StatisticsUtils2.addIncrement("aaaaaaaaaaaa");
                                StatisticsUtils2.addIncrement("bbbbbbbbbbbb");
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
