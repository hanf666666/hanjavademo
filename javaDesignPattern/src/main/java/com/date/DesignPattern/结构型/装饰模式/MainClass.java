package com.date.DesignPattern.�ṹ��.װ��ģʽ;

public class MainClass {
    public static void main(String[] args) {
        Blacktea blacktea = new Blacktea();
        System.out.println("����==>"+blacktea.getDescription()+",�۸�"+blacktea.cost());
        AbstractCondiment lemon = new Lemon(blacktea);
        System.out.println("���ϼӵ���==>"+lemon.getDescription()+",�۸�"+lemon.cost());
    }
}
