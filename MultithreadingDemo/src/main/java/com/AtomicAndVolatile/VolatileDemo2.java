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

// ����֤ԭ����
public class VolatileDemo2 {

    private static int num = 0;

    public static void add() {
        num++;
    }
    // 1���˴���ʹ�� synchronized ���
    public synchronized void add2() {
        num++;
    }

    private static Lock lock = new ReentrantLock();
    // 2���˴���ʹ�� lock ���
    public static void add3() {
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {// main gc
            Thread.yield();
        }

        System.out.println("num=" + num);
    }

}
