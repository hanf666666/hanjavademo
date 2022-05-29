package com.date.DesignPattern.结构型.装饰模式;

public class MainClass {
    public static void main(String[] args) {
        Blacktea blacktea = new Blacktea();
        System.out.println("饮料==>"+blacktea.getDescription()+",价格"+blacktea.cost());
        AbstractCondiment lemon = new Lemon(blacktea);
        System.out.println("饮料加调料==>"+lemon.getDescription()+",价格"+lemon.cost());
    }
}
