package com.concurrent;

/**
 * 重排序
 * 按程序顺序（intra-thread semantics）和线程交错推理：
 *
 *     x = 0 意味着 t1 的 ② 在 t2 的 ③ 之前执行（读 b 时 b 还是 0）；
 *
 *     y = 0 意味着 t2 的 ④ 在 t1 的 ① 之前执行（读 a 时 a 还是 0）。
 */
public class ReorderingDemo {

    static int a, b;   // 普通变量
    static int x, y;   // 用来保存读到的结果

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; ; i++) {
            a = b = x = y = 0;

            Thread t1 = new Thread(() -> {
                a = 1;      // ①
                x = b;      // ②
            });

            Thread t2 = new Thread(() -> {
                b = 1;      // ③
                y = a;      // ④
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            // 正常情况下 x、y 不可能同时为 0
            if (x == 0 && y == 0) {
                System.out.println("第 " + i + " 次：x=0, y=0 —— 发生了重排序！");
                break;
            }
        }
    }
}
