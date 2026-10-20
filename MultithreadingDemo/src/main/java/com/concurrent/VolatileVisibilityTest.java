package com.concurrent;

public class VolatileVisibilityTest {

    // 加上 volatile 关键字，保证多线程之间的可见性
    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data...");
            while (!initFlag) {
                // 死循环等待数据准备完成
            }
            System.out.println("===============success");
        }).start();

        // 主线程休息 2 秒，确保上面的子线程已经开始执行了
        Thread.sleep(2000);

        // 启动新线程去修改共享变量
        new Thread(() -> prepareData()).start();
    }

    public static void prepareData() {
        System.out.println("prepare data...");
        initFlag = true;
        System.out.println("prepare data end...");
    }
}
