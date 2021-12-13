package com.Thread.�ṹ��.������ģʽ.����������ģʽ;

public class MainClass {
    public static void main(String[] args) {
        /**
         * �������Ѽ
         */
        CockAdapter cockAsDuck = new CockAdapter(new CockImpl());
        cockAsDuck.quack();
        cockAsDuck.fly();

    }
}
