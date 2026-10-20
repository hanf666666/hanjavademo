package com.concurrent;

/**
 * synchronized 无锁-偏向锁-轻量级锁-重量级锁
 * 自适应自旋
 *
 *
 */
public class AdaptiveSpinDemo {

    private static final Object lock = new Object();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 线程1 抢到了锁，执行了极短的时间（模拟临界区极短）
            synchronized (lock) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            // 线程2 没抢到锁。
            // 此时 JVM 发现锁已经被 t1 拿了，并且临界区很短。
            // JVM 不会直接把 t2 挂起（阻塞），而是让 t2 在这里【自适应自旋】。
            // 如果 t2 自旋了几次，t1 就释放锁了，t2 就能立刻拿到锁，全程在用户态。
            synchronized (lock) {
                count++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
