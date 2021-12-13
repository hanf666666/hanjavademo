package com.it.创建型.简单工厂模式;



public class FoodFactory {
    public static Food makeFood(String foodstr){

        if(foodstr.equalsIgnoreCase("apple"))
        {
            System.out.println("apple被生产");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("manggu"))
        {System.out.println("manggu被生产");
            return  new Manggu();
        }else {
            System.out.println("我们找不到这个食物");
            throw new RuntimeException("这个食物我们不生产!!!!");
        }


    }
}
