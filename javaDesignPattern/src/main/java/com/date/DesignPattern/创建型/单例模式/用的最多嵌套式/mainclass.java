package com.date.DesignPattern.������.����ģʽ.�õ����Ƕ��ʽ;



public class mainclass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance11 = Singleton.getInstance();
        System.out.println(instance==instance11);

    }
}
