package com.date.DesignPattern.行为型模式.策略模式;


public class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("???????????radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
