package com.it.DesignPattern.创建型.单例模式.饱汉模式;

import com.it.DesignPattern.创建型.单例模式.用的最多嵌套式.Singleton;

public class mainclass {
    public static void main(String[] args) {
        com.it.DesignPattern.创建型.单例模式.用的最多嵌套式.Singleton instance = com.it.DesignPattern.创建型.单例模式.用的最多嵌套式.Singleton.getInstance();
        com.it.DesignPattern.创建型.单例模式.用的最多嵌套式.Singleton instance11 = Singleton.getInstance();
        //Singleton.getDate("das");
    }
}
