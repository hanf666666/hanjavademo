package com.Thread.��Ϊ��ģʽ.�۲���ģʽ;

public class MainClass {
    public static void main(String[] args) {
        Subject subject = new Subject();


        new BinaryObserver(subject);
        new HexaObserver(subject);
        // ģ�����ݱ�������ʱ�򣬹۲����ǵ� update �������ᱻ����
        subject.setState(11);
    }
}
