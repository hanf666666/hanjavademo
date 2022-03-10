package com.date.DesignPattern.创建型.单例模式.饿汉模式;

import java.util.Date;

public class Singleton  {

    private Singleton(){
        System.out.println("构造");
    }
    private static Singleton instance=  new Singleton();
    public static Singleton getInstance() {
        return instance;
    }


    public static Date getDate(String mode) {

        System.out.println("getDate");
        return new Date();}

}
