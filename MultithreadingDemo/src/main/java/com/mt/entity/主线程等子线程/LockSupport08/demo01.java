package com.mt.entity.主线程等子线程.LockSupport08;

import java.util.concurrent.locks.LockSupport;

public class demo01 {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        Thread t = new Thread(() -> {
            //子线程进行字符串连接操作
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            LockSupport.unpark(mainThread);
        });
//开始计时
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        LockSupport.park();// 相当于暂停主线程
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));




    }
}
