package com.it.test07_多线程模拟卖票_实现Runnable接口版;

public class Test {
    public static void main(String[] args) {
        //3. 在测试类中创建对象, 测试.
        //创建Runnable接口的子类对象
        MyRunnable mr = new MyRunnable();
        //将其作为参数传入Thread类的构造方法, 创建线程对象.
        //public Thread(Runnable target);
        //public Thread(Runnable target, String name);
        Thread th1 = new Thread(mr, "窗口1");
        Thread th2 = new Thread(mr, "窗口2");
        Thread th3 = new Thread(mr, "窗口3");
        Thread th4 = new Thread(mr, "窗口4");

        //开启线程
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
