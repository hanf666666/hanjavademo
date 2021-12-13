package com.it.创建型.单例模式.饱汉模式;

public class mainclass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance11 = Singleton.getInstance();
        //Singleton.getDate("das");
    }
}
