package com.主线程等子线程.synchronized2;

/**
 * 不太明白 Object能锁住
 */
public class demo {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t Over");
            synchronized (lock) {
                System.out.println("我怎么进来了");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();//子线程唤醒
            }
        });
        //计时
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        //启动子线程
        t.start();
        try {
            synchronized (lock) {
                System.out.println("锁死======》");
                lock.wait();//主线程等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));


    }
}
