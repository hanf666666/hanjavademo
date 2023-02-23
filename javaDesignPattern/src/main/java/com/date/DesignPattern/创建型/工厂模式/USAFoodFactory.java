package com.date.DesignPattern.创建型.工厂模式;


public class USAFoodFactory implements FoodFactory {
    public USAFoodFactory() {
        System.out.println("USAFoodFactory构造");
    }

    public Food makeFood(String foodstr){


        if(foodstr.equalsIgnoreCase("uapple"))
        {
            System.out.println("美国工场的uapple");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("umanggu"))
        {System.out.println("美国工场的umangguo");
            return  new UMangguo();
        }else {
            System.out.println("美国工场不能生产的"+foodstr);
            throw new RuntimeException("美国工场不能生产的"+foodstr);
        }


    }
}
