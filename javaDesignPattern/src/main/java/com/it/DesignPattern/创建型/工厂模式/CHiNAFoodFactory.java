package com.it.DesignPattern.������.����ģʽ;

public class CHiNAFoodFactory implements FoodFactory {
    public CHiNAFoodFactory() {
        System.out.println("?????��?????");
    }

    public Food makeFood(String foodstr) {

        if (foodstr.equalsIgnoreCase("apple")) {
            System.out.println("apple???��???????");
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
