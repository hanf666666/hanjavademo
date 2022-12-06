package com.date.DesignPattern.结构型.适配器模式.对象适配器模式;

public class MainClass {
    public static void main(String[] args) {
        // 有一只野鸡
        Cock wildCock = new WildCock();
        // 成功将野鸡适配成鸭
        Duck duck = new CockAdapter(wildCock);
        duck.fly();
        duck.quack();

    }
}
