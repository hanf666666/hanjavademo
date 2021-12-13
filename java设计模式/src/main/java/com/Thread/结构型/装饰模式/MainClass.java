package com.Thread.�ṹ��.װ��ģʽ;

public class MainClass {
    public static void main(String[] args) {
        Blacktea blacktea = new Blacktea();
        System.out.println("���=="+blacktea.getDescription()+",�۸�"+blacktea.cost());
        Lemon lemon = new Lemon(blacktea);
        System.out.println("���ӹ�������=="+lemon.getDescription()+",�۸�"+lemon.cost());
    }
}
