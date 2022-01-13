package com.date.test02_实现方式一_继承Thread类;

/**
 * 测试类, 测试MyThread的类.
 */
public class Test {
    /*
        main函数是程序的主入口,
        所有代码的执行都是从这里开始的.
     */
    public static void main(String[] args) {
       // D: 创建线程对象.
        MyThread mt = new MyThread();

       // E: 开启线程.
        /*
            小细节:
                1. 开启线程必须调用start()方法, 该方法会自动调用run().
                2. 同一线程不能重复开启, 否者会报:IllegalThreadStateException(非法的线程状态异常)
         */
        //mt.run();   //这里如果调用run(), 只是普通的方法调用.
        mt.start();
       // mt.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main..........." + i);
        }
    }
}
