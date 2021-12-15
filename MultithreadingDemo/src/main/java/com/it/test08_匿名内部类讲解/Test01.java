package com.it.test08_匿名内部类讲解;

public class Test01 {
    //成员变量
    private int num;

    //成员内部类
    class Inner{

    }

    //成员方法
    public void show() {
        //局部变量
        int num = 10;

        //局部内部类
        class Inner2{

        }
    }
}
