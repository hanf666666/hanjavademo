package com.it.创建型.单例模式.用的最多嵌套式;

import java.util.Date;

public class Singleton {

    private Singleton() {
        System.out.println("用的最多嵌套式");
    }
    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性

    public static Singleton getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        public static Singleton instance= new Singleton();

    }

}
