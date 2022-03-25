package com.AtomicAndVolatile;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/25
 */
import java.util.concurrent.atomic.AtomicInteger;

// 不保证原子性
public class AtomicIntegerDemo {


    public static void add(AtomicInteger num) {
        num.getAndIncrement();// AtomicInteger+1 方法 CAS
    }

    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add(num);
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {// main gc
            Thread.yield();
        }

        System.out.println("num=" + num);
    }

}

