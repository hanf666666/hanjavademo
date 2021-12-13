package com.it.结构型.装饰模式;

public class MainClass {
    public static void main(String[] args) {
        Blacktea blacktea = new Blacktea();
        System.out.println("红茶=="+blacktea.getDescription()+",价格"+blacktea.cost());
        Lemon lemon = new Lemon(blacktea);
        System.out.println("红茶加工成柠檬=="+lemon.getDescription()+",价格"+lemon.cost());
    }
}
