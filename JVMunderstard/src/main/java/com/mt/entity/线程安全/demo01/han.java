package com.mt.entity.线程安全.demo01;

public class han {
    public static void main(String[] args) {
        int a=0;
        a=++a;
        System.out.println(a);
    }
}
