package com.date.DesignPattern.�ṹ��.������ģʽ.����������ģʽ;

// �������ʣ����ȣ�����������϶���Ҫ implements Duck���������ܵ���Ѽ����
//����:������cockҪDuck���ɽ�
public class CockAdapter implements Duck {

    Cock cock;
    // ���췽������Ҫһ������ʵ����������ǽ���ֻ�������Ѽ����
    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    // ʵ��Ѽ�����ɽз���
    @Override
    public void quack() {
        // �ڲ���ʵ��һֻ���Ĺ�����
        cock.gobble();
    }

    @Override
    public void fly() {
        cock.fly();
    }
}
