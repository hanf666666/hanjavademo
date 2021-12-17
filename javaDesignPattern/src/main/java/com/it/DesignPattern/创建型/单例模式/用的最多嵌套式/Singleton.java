package com.it.DesignPattern.������.����ģʽ.�õ����Ƕ��ʽ;

public class Singleton {

    private Singleton() {
        System.out.println("??????????");
    }


    public static Singleton getInstance(){
        return Holder.instance;
    }

    private static class Holder{
        public static Singleton instance= new Singleton();

    }

}
