package com.date.DesignPattern.������.����ģʽ.�õ����Ƕ��ʽ;



public class mainclass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("========================");
        Singleton instance11 = Singleton.getInstance();
        System.out.println("========================");

        System.out.println(instance==instance11);

    }
}
