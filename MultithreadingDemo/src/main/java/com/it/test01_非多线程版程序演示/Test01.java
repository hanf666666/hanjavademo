package com.it.test01_非多线程版程序演示;

public class Test01 {
    public static void main(String[] args) {
        //普通for的格式: fori
        for (int i = 0; i < 200; i++) {
            System.out.println("main..........." + i);
        }

       // System.out.println(1/0);

        //问: 第一个for执行结束前, 会不会执行第二个for?
        //不会, 因为代码是从上往下, 从左往右依次逐行执行的.
    }
}
