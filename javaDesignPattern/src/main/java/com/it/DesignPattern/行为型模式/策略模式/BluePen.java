package com.it.DesignPattern.行为型模式.策略模式;


public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("???????????radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
