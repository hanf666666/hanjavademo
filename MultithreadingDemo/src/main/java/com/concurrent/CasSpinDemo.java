package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * while自旋+CAS判断
 *
 */
public class CasSpinDemo {

    // AtomicInteger 底层就是靠 CAS + volatile 实现的
    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 启动 10 个线程，每个线程加 1000 次
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    // 【重点看这里】：这就是所谓的 CAS 自旋！
                    // 它的本质是一个 while(true) 循环
                    while (true) {
                        int current = atomicInt.get(); // 1. 获取期望的当前值
                        int next = current + 1;        // 2. 计算目标值

                        // 3. compareAndSet (CAS操作)：
                        // 如果主内存里的值等于 current，就把它更新为 next 并返回 true。
                        // 如果不等（说明被别的线程抢先改了），就返回 false，继续循环（自旋）。
                        if (atomicInt.compareAndSet(current, next)) {
                            break; // 更新成功，跳出循环
                        }
                        // 如果没成功，什么都不做，立刻再次进入 while 循环重试
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("最终结果: " + atomicInt.get()); // 一定是 10000
    }
}
