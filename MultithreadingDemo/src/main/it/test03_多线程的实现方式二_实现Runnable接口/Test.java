package com.date.test03_多线程的实现方式二_实现Runnable接口;

public class Test {
    public static void main(String[] args) {
        //D: 创建线程.
        //创建Runnable接口的子类对象.
        MyRunnable mr = new MyRunnable();

        //将其作为参数传入Thread类的构造, 创建线程对象.
        //public Thread(Runnable target)
        Thread th = new Thread(mr);

        //E: 开启线程
        th.start();


        for (int i = 0; i < 200; i++) {
            System.out.println("main..." + i);
        }
    }
}
