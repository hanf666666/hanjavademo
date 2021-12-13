package com.it.test08_匿名内部类讲解;

public class Test05_什么时候使用匿名内部类 {
    public static void main(String[] args) {
        //需求: 调用Inter#method1();

       Inter in =  new Inter() {
            @Override
           public void method1() {
               System.out.println("method1");
           }
           @Override
           public void method2() {
               System.out.println("method2");
           }
           @Override
           public void method3() {
               System.out.println("method3");
           }
           @Override
           public void method4() {
               System.out.println("method4");
           }
        };
       in.method1();

       //需求: 创建两个Inner接口的子类对象.
    }
}

