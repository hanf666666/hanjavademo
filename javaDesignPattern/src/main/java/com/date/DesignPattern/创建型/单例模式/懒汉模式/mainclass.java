package com.date.DesignPattern.������.����ģʽ.����ģʽ;

public class mainclass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance==instance1);
    }
}
