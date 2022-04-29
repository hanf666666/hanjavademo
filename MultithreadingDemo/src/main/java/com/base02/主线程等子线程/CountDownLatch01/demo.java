package com.base02.主线程等子线程.CountDownLatch01;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class demo {
    public static void main(String[] args) {
        int threadNumber = 4;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);//参数为线程个数

        for (int i = 1; i <10 ; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(finalI *1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();//此方法是CountDownLatch的线程数-1
            });
            t.start();
        }

        long start = System.currentTimeMillis();
        System.out.println("start = " + start);

       //线程启动后调用countDownLatch方法
        try {
            //需要捕获异常，当其中线程数为0时这里才会继续运行
            countDownLatch.await();
            System.out.println("=====================");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));

    }
}
