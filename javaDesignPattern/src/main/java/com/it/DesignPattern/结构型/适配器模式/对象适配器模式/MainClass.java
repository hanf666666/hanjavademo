package com.it.DesignPattern.�ṹ��.������ģʽ.����������ģʽ;

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
