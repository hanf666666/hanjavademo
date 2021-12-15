package com.主线程等子线程.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class demo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);//参数为线程数
        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            try {
                barrier.await();//阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        try {
            barrier.await();//也阻塞,并且当阻塞数量达到指定数目时同时释放
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));




    }
}
