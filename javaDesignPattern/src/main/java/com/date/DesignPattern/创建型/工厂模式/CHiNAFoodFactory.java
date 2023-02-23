package com.date.DesignPattern.������.����ģʽ;

public class CHiNAFoodFactory implements FoodFactory {

    public  String apple="apple";
    public  String mangguo="mangguo";

    public CHiNAFoodFactory() {
        System.out.println("�й�����CHiNAFoodFactory");
    }


    public Food makeFood(String foodstr) {

        if (apple.equals(foodstr)) {
            System.out.println("�й�������apple");
            return new Apple();
        } else if (mangguo.equals(foodstr)) {
            System.out.println("�й�������mangguo");
            return new Mangguo();
        } else {
            System.out.println("�й�����������������"+foodstr);
            throw new RuntimeException("�й�����������������"+foodstr);
        }


    }
}
