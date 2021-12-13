package com.it.创建型.简单工厂模式;

public class MainClass {
    public static void main(String[] args) {

        Food apple = FoodFactory.makeFood("Apple");
        Food manggo = FoodFactory.makeFood("manggo");

    }
}
