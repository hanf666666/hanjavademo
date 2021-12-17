package com.it.DesignPattern.创建型.工厂模式;


public class USAFoodFactory implements FoodFactory {
    public USAFoodFactory() {
        System.out.println("????????????");
    }

    public Food makeFood(String foodstr){



        if(foodstr.equalsIgnoreCase("uapple"))
        {
            System.out.println("uapple????????????");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("umanggu"))
        {System.out.println("umanggu??????");
            return  new UManggu();
        }else {
            System.out.println("???????????????");
            throw new RuntimeException("???????????????!!!!");
        }


    }
}
