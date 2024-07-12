package com.date.DesignPattern.行为型模式.策略模式.test1;


public class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色笔画图radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
