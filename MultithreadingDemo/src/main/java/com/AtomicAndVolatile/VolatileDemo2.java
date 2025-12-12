package com.AtomicAndVolatile;

import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/25
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 不保证原子性
public class VolatileDemo2 {

    private static int num = 0;

    public static void add() {
        num++;
    }
    // 1、此处可使用 synchronized 解决
    public synchronized void add2() {
        num++;
    }

    private static Lock lock = new ReentrantLock();
    // 2、此处可使用 lock 解决
    public static void add3() {
        lock.lock();
        try {
            num++;
            try {
                Thread.sleep(3000);
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    add3();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {// main gc
            Thread.yield();
        }

        System.out.println("num=" + num);
    }

}
