package com.Thread.������.����ģʽ.�õ����Ƕ��ʽ;

import java.util.Date;

public class Singleton {

    private Singleton() {
        System.out.println("�õ����Ƕ��ʽ");
    }
    // ��Ҫ��ʹ���� Ƕ������Է����ⲿ��ľ�̬���Ժ;�̬���� ������

    public static Singleton getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        public static Singleton instance= new Singleton();

    }

}
