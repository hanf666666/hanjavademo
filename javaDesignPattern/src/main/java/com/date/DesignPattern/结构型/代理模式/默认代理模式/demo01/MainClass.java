package com.date.DesignPattern.结构型.代理模式.默认代理模式.demo01;

public class MainClass {


    public static void main(String[] args) {
        // ??????????????????
        FoodService foodService = new FoodServiceProxy();
        foodService.makeChicken();
    }
}
