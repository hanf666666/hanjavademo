package com.date.DesignPattern.������.����ģʽ;



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
