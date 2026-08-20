package com.newsfeatures;

/**
 * @author Hj
 * @date 2026/8/20
 */
public class Demo111 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1111111111);
        });
        //在程序结束时会被强制结束,不设置守护线程就会阻塞主线程
        thread.setDaemon(true);

        thread.start();
        System.out.println("主");

    }
}
