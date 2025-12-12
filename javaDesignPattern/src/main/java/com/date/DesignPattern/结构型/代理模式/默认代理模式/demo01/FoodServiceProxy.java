package com.date.DesignPattern.结构型.代理模式.默认代理模式.demo01;

public class FoodServiceProxy implements FoodService {
    private FoodService foodService = new FoodServiceImpl();

    public Food makeChicken() {
        System.out.println("makeChicken");
        Food food = foodService.makeChicken();
        System.out.println("makeChicken完成"+food); // 
        //food.addCondiment("pepper");

        return food;
    }
    public Food makeNoodle() {
        System.out.println("makeNoodle");
        Food food = foodService.makeNoodle();
        System.out.println("makeNoodle完成"+food);
        return food;
    }
}
