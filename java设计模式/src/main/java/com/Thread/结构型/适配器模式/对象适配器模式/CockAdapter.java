package com.Thread.�ṹ��.������ģʽ.����������ģʽ;

public class CockAdapter implements Duck {

    Cock cock;
    // ���췽������Ҫһ������ʵ����������ǽ���ֻ�������Ѽ����
    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    @Override
    public void quack() {
        cock.gobble();

    }

    @Override
    public void fly() {
        cock.fly();

    }
}
