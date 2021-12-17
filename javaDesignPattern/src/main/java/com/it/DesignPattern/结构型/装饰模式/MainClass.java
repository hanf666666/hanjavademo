package com.it.DesignPattern.结构型.装饰模式;

public class MainClass {
    public static void main(String[] args) {
        Blacktea blacktea = new Blacktea();
        System.out.println("???=="+blacktea.getDescription()+",???"+blacktea.cost());
        Lemon lemon = new Lemon(blacktea);
        System.out.println("???????????=="+lemon.getDescription()+",???"+lemon.cost());
    }
}
