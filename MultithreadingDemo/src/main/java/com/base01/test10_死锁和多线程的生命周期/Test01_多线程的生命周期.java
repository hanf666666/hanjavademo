package com.base01.test10_死锁和多线程的生命周期;

import java.util.Scanner;

public class Test01_多线程的生命周期 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄");
        System.out.println("哈哈, 这么巧啊, 我也" + sc.nextInt() + "岁了, 这么巧, 加个飞秋呗!");
    }
}
