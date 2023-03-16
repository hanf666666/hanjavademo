package com.map.maptest01;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *  �����̰߳�ȫ ���Բ�ʹ��volatile���Խ�ָֹ���������
 *  https://blog.csdn.net/liangwenmail/article/details/119380136
 *  Integer ���̰߳�ȫ
 * @author Hj
 * @date 2023/3/15
 */
public class StatisticsUtils4 {
    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();

    public static void addIncrement(String tableName) {
        Integer count  = StatisticsUtils4.concurrentHashMap.get(tableName);
        if (count == null) {
            synchronized (StatisticsUtils4.class) {
                count  = StatisticsUtils4.concurrentHashMap.get(tableName);
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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("aaaaaaaaaaaa=======>1000000");
        for (int f = 0; f < 100; f++) {
            concurrentHashMap = new ConcurrentHashMap();
            ExecutorService executorService = Executors.newFixedThreadPool(100);
            ArrayList<Future> futureArrayList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                futureArrayList.add(
                        executorService.submit(() -> {
                            for (int j = 0; j < 10000; j++) {
                                StatisticsUtils4.addIncrement("aaaaaaaaaaaa");
                                StatisticsUtils4.addIncrement("bbbbbbbbbbbb");
                            }

                        })

                );

            }
            // �ȴ�
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
                System.out.println(k + "=======>" + v);


            });

        }


    }

}
