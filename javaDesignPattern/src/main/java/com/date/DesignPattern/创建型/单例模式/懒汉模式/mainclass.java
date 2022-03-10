package com.date.DesignPattern.创建型.单例模式.懒汉模式;

public class mainclass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance==instance1);
    }
}
