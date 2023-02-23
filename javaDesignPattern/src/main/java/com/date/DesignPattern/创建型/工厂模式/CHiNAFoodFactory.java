package com.date.DesignPattern.创建型.工厂模式;

public class CHiNAFoodFactory implements FoodFactory {

    public  String apple="apple";
    public  String mangguo="mangguo";

    public CHiNAFoodFactory() {
        System.out.println("中国工厂CHiNAFoodFactory");
    }


    public Food makeFood(String foodstr) {

        if (apple.equals(foodstr)) {
            System.out.println("中国工厂的apple");
            return new Apple();
        } else if (mangguo.equals(foodstr)) {
            System.out.println("中国工厂的mangguo");
            return new Mangguo();
        } else {
            System.out.println("中国工厂还不能生产的"+foodstr);
            throw new RuntimeException("中国工厂还不能生产的"+foodstr);
        }


    }
}
