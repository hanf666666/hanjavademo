package com.date.DesignPattern.������.����ģʽ;


public class USAFoodFactory implements FoodFactory {
    public USAFoodFactory() {
        System.out.println("USAFoodFactory����");
    }

    public Food makeFood(String foodstr){


        if(foodstr.equalsIgnoreCase("uapple"))
        {
            System.out.println("����������uapple");
           return  new Apple();
        }else if(foodstr.equalsIgnoreCase("umanggu"))
        {System.out.println("����������umangguo");
            return  new UMangguo();
        }else {
            System.out.println("������������������"+foodstr);
            throw new RuntimeException("������������������"+foodstr);
        }


    }
}
