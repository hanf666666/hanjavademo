package com.date.DesignPattern.创建型.简单工厂模式;

public class FoodFactory {
    public static Food makeFood(String foodstr){

        if(foodstr.equalsIgnoreCase("apple"))
        {
            System.out.println("apple");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("manggu"))
        {System.out.println("manggu");
            return  new Manggu();
        }else {
            System.out.println("?");
            throw new RuntimeException("?!!!!");
        }


    }
}
