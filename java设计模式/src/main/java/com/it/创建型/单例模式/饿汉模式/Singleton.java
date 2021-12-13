package com.it.创建型.单例模式.饿汉模式;

import java.util.Date;

//单例类
public class Singleton  {
    //调用就会创建
    private Singleton(){
        System.out.println("饿汉模式");
    }
    private static Singleton instance=  new Singleton();
    public static Singleton getInstance() {
        return instance;
    }

    // 瞎写一个静态方法。这里想说的是，如果我们只是要调用 Singleton.getDate(...)，
    // 本来是不想要生成 Singleton 实例的，不过没办法，已经生成了
    public static Date getDate(String mode) {

        System.out.println("getDate");
        return new Date();}

}
