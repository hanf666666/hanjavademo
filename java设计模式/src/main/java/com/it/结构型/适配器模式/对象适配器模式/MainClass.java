package com.it.结构型.适配器模式.对象适配器模式;

public class MainClass {
    public static void main(String[] args) {
        /**
         * 鸡适配成鸭
         */
        CockAdapter cockAsDuck = new CockAdapter(new CockImpl());
        cockAsDuck.quack();
        cockAsDuck.fly();

    }
}
