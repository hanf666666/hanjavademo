package com.it.创建型.工厂模式;


public class CHiNAFoodFactory implements FoodFactory{
    public CHiNAFoodFactory() {
        System.out.println("我是中国工厂");
    }

    public  Food makeFood(String foodstr){

        if(foodstr.equalsIgnoreCase("apple"))
        {
            System.out.println("apple在中国被生产");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("manggu"))
        {System.out.println("manggu被生产");
            return  new UManggu();
        }else {
            System.out.println("我们找不到这个食物");
            throw new RuntimeException("这个食物我们不生产!!!!");
        }


    }
}
