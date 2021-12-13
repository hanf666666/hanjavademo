package com.it.创建型.工厂模式;


public class USAFoodFactory implements FoodFactory{
    public USAFoodFactory() {
        System.out.println("我是美国工厂");
    }

    public  Food makeFood(String foodstr){



        if(foodstr.equalsIgnoreCase("uapple"))
        {
            System.out.println("uapple在美国被生产");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("umanggu"))
        {System.out.println("umanggu被生产");
            return  new UManggu();
        }else {
            System.out.println("我们找不到这个食物");
            throw new RuntimeException("这个食物我们不生产!!!!");
        }


    }
}
