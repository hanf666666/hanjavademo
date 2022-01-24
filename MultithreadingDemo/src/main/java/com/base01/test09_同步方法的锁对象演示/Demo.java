package com.base01.test09_同步方法的锁对象演示;

public class Demo {
    public static synchronized void method1() {
        //这个用同步方法
        System.out.print("i");
        System.out.print("t");
        System.out.print("c");
        System.out.print("a");
        System.out.print("s");
        System.out.print("t");
        System.out.print("\r\n");
    }

    public static void method2() {
        //这个用同步代码块
        synchronized(Demo.class) {
            System.out.print("黑");
            System.out.print("马");
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("\r\n");
        }
    }
}
