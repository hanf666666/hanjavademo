package com.it.DesignPattern.创建型.单例模式.用的最多嵌套式;

public class Singleton {

    private Singleton() {
        System.out.println("??????????");
    }


    public static Singleton getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        public static Singleton instance= new Singleton();

    }

}
