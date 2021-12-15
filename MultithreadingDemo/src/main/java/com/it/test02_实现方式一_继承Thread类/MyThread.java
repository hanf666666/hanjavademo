package com.it.test02_实现方式一_继承Thread类;

/**
 * 这个是自定义的线程类: MyThread
 */

//A: 定义一个类(MyThread), 继承Thread类.
public class MyThread extends Thread{
    //B: 重写Thread#run().

    @Override
    public void run() {
        //C: 把要执行的代码放入到run()中.
        for (int i = 0; i < 200; i++) {
            System.out.println("run...." + i);
        }
    }
}
