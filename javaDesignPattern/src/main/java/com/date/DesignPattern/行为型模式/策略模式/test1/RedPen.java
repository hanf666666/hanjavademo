package com.date.DesignPattern.行为型模式.策略模式.test1;

public class RedPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用红色笔画图radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
