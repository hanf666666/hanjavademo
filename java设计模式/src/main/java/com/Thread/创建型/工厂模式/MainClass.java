package com.Thread.������.����ģʽ;

public class MainClass {
    public static void main(String[] args) {
        CHiNAFoodFactory cHiNAFoodFactory = new CHiNAFoodFactory();
        cHiNAFoodFactory.makeFood("Apple");

        USAFoodFactory usaFoodFactory = new USAFoodFactory();
        Food apple = usaFoodFactory.makeFood("Uapple");


    }
}
