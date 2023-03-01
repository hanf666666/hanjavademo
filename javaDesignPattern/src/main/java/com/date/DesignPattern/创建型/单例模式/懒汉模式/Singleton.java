package com.date.DesignPattern.创建型.单例模式.懒汉模式;

import java.util.Date;

/**
 * 双重检测单实例 dcl
 */
//单例模式
public class Singleton {
    private Singleton() {
        System.out.println("构造");
    }

    private static volatile Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    System.out.println("======================");
                   // return new Singleton();
                    instance = new Singleton();
                }

            }

        }
        return instance;

    }

    public static Date getDate(String mode) {

        System.out.println("getDate");
        return new Date();
    }

}
