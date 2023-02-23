package com.date.DesignPattern.创建型.单例模式.用的最多嵌套式;



public class mainclass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("========================");
        Singleton instance11 = Singleton.getInstance();
        System.out.println("========================");

        System.out.println(instance==instance11);

    }
}
