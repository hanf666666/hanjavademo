package com.AtomicAndVolatile;

import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/25
 */
public class VolatileDemo {

    // 不加 volatile 程序就会死循环
    // 加  volatile 可以保证可见性
    private volatile static int flag = 0;

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            // 线程1 对主内存的变化不可知
            while (flag == 0) {
                System.out.println("222222");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        flag=1;
        System.out.println("1111111111111111");
    }
}