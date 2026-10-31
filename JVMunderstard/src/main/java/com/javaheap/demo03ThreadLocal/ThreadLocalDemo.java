package com.javaheap.demo03ThreadLocal;

public class ThreadLocalDemo {

    // 普通共享变量：所有线程读写的是同一块内存
    private static volatile String sharedVar = "初始值";

    // ThreadLocal：每个线程各有一份副本
    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            String name = Thread.currentThread().getName();

            // 各自写
            LOCAL.set(name + "-的私有数据");
            sharedVar = name + "-的共享数据";

            // 停一下，让别的线程有机会改写 sharedVar
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}

            // 各自读
            System.out.println(name + " | ThreadLocal : " + LOCAL.get());
            System.out.println(name + " | sharedVar   : " + sharedVar);

            // 用完移除，防止线程池复用线程时脏数据
            LOCAL.remove();
        };

        Thread t1 = new Thread(task, "线程A");
        Thread t2 = new Thread(task, "线程B");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
