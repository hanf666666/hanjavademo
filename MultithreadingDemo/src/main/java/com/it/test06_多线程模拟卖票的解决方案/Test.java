package com.it.test06_多线程模拟卖票的解决方案;

/**
 * 测试类, 模拟卖票
 */
public class Test {
    public static void main(String[] args) {
        //3. 在测试类中, 创建4个线程, 卖票.
        /*MyThread mt1 = new MyThread();
        mt1.setName("窗口1");*/

        MyThread mt1 = new MyThread("窗口1");
        MyThread mt2 = new MyThread("窗口2");
        MyThread mt3 = new MyThread("窗口3");
        MyThread mt4 = new MyThread("窗口4");

        //开启线程
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
    }
}
