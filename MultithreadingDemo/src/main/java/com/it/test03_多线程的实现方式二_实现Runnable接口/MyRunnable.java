package com.it.test03_多线程的实现方式二_实现Runnable接口;

//A: 定义类(MyRunnable类), 实现Runnable接口
public class MyRunnable implements  Runnable {

    //B: 重写接口中的run()方法.
    @Override
    public void run() {
        //C: 把要执行的代码放到run()方法中.
        for (int i = 0; i < 200; i++) {
            System.out.println("实现Runnable接口的方式实现多线程..." + i);
        }
    }
}
