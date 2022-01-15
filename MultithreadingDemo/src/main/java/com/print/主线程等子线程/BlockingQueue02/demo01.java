package com.print.主线程等子线程.BlockingQueue02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class demo01 {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1);//数组型队列，长度为1
        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            try {
                queue.put("OK");//在队列中加入数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        try {
            queue.take();//主线程在队列中获取数据，take()方法会阻塞队列，ps还有不会阻塞的方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));




    }
}
