package com.it.DesignPattern.�ṹ��.װ��ģʽ;

public class MainClass {
    public static void main(String[] args) {
        Blacktea blacktea = new Blacktea();
        System.out.println("???=="+blacktea.getDescription()+",???"+blacktea.cost());
        Lemon lemon = new Lemon(blacktea);
        System.out.println("???????????=="+lemon.getDescription()+",???"+lemon.cost());
    }
}
