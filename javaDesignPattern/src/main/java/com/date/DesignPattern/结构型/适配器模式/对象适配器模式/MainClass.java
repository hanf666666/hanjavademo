package com.date.DesignPattern.结构型.适配器模式.对象适配器模式;

public class MainClass {
    public static void main(String[] args) {
        /**
         * ????????
         */
        CockAdapter cockAsDuck = new CockAdapter(new CockImpl());
        cockAsDuck.quack();
        cockAsDuck.fly();

    }
}
