package com.date.DesignPattern.创建型.工厂模式;



public class MainClass {
    public static void main(String[] args) {
        CHiNAFoodFactory cHiNAFoodFactory = new CHiNAFoodFactory();
        cHiNAFoodFactory.makeFood(ChinaFoodEnum.apple.name());
        cHiNAFoodFactory.makeFood(ChinaFoodEnum.mangguo.name());

        System.out.println("=======================>");
        USAFoodFactory usaFoodFactory = new USAFoodFactory();
        Food apple = usaFoodFactory.makeFood("Uapple");


    }
}
