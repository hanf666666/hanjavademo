package com.date.DesignPattern.创建型.工厂模式;

public class CHiNAFoodFactory implements FoodFactory {

    public CHiNAFoodFactory() {
        System.out.println("中国工厂CHiNAFoodFactory");
    }

    public Food makeFood(String foodstr) {

        if (ChinaFoodEnum.apple.name().equals(foodstr)) {
            System.out.println("中国工厂的apple");
            return new Apple();
        } else if (ChinaFoodEnum.mangguo.name().equals(foodstr)) {
            System.out.println("中国工厂的mangguo");
            return new Mangguo();
        } else {
            System.out.println("中国工厂还不能生产的"+foodstr);
            throw new RuntimeException("中国工厂还不能生产的"+foodstr);
        }


    }
}
