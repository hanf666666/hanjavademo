package com.it.结构型.代理模式.默认代理模式.demo01;

public class MainClass {


    public static void main(String[] args) {
        // 这里用代理类来实例化
        FoodService foodService = new FoodServiceProxy();
        foodService.makeChicken();
    }
}
