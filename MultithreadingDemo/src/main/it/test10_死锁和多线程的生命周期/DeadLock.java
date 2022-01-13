package com.date.test10_死锁和多线程的生命周期;

/**
 * 死锁代码演示
 */
public class DeadLock {
    //两把锁
    private static final String LOCKA = "锁A";
    private static final String LOCKB = "锁B";

    public static void main(String[] args) {
        /*
            核心思想:
                1. 两个线程, 两把锁.
                2. 一个线程先A,后B,
                    另一个线程先B, 后A.
                3. 为了让效果更明显, 用while(true)改进.
         */
        //线程1,  一个线程先A,后B,
        new Thread(){
            @Override
            public void run() {
                while(true) {

                    //先A
                    synchronized (LOCKA) {
                        System.out.println("1获取到" + LOCKA + ", 等待" + LOCKB);
                        //后B
                        synchronized (LOCKB) {
                            System.out.println("1获取到" + LOCKB + ", 成功进到了小房间");
                        }
                    }
                }
            }
        }.start();

        //线程2,  一个线程先B,后A,
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    //先B
                    synchronized (LOCKB) {
                        System.out.println("2获取到" + LOCKB + ", 等待" + LOCKA);
                        //后A
                        synchronized (LOCKA) {
                            System.out.println("2获取到" + LOCKA + ", 成功进到了小房间");
                        }
                    }
                }
            }
        }.start();

    }
}
