package com.it.test09_同步方法的锁对象演示;

public class Test2_非静态 {
    public static void main(String[] args) {
        /*
        	核心思路:
                1. 创建两个线程, 一个调用method1, 另一个调用method2().
                2. 如果打印结果没乱序, 就说明他们使用的是同一把锁.
                3. 为了让效果更明显, 用while(true)改进.
         */
        //创建  Demo2_非静态   类的对昂
       final  Demo2_非静态 d = new Demo2_非静态();

        //线程1, 调用method1()
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    d.method1();
                }
            }
        }.start();

        //线程2, 调用method2().
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    d.method2();
                }
            }
        }.start();

        //方式一: 继承Thread类.
        //new Thread(){
        //  重写run();
        // }.start();

        //方式二: 实现Runnable接口.
        /*new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();*/


    }
}
