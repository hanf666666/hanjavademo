package com.it.DesignPattern.创建型.工厂模式;

public class CHiNAFoodFactory implements FoodFactory {
    public CHiNAFoodFactory() {
        System.out.println("?????й?????");
    }

    public Food makeFood(String foodstr) {

        if (foodstr.equalsIgnoreCase("apple")) {
            System.out.println("apple???й???????");
            return new Apple();
        } else if (foodstr.equalsIgnoreCase("manggu")) {
            System.out.println("manggu??????");
            return new UManggu();
        } else {
            System.out.println("???????????????");
            throw new RuntimeException("???????????????!!!!");
        }


    }
}
