package com.date.DesignPattern.������.����ģʽ.�õ����Ƕ��ʽ;

public class Singleton {

    private Singleton() {
        System.out.println("˽�й���");
    }


    public static Singleton getInstance(){
        System.out.println("��ȡSingletonʵ��");
        return Holder.instance;
    }

    private static class Holder{
        public static Singleton instance= new Singleton();

    }

}
