package com.date.DesignPattern.�ṹ��.������ģʽ.����������ģʽ;

public class MainClass {
    public static void main(String[] args) {
        // ��һֻҰ��
        Cock wildCock = new WildCock();
        // �ɹ���Ұ�������Ѽ
        Duck duck = new CockAdapter(wildCock);
        duck.fly();
        duck.quack();

    }
}
