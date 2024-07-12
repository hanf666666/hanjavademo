package com.date.DesignPattern.行为型模式.策略模式.test1;


public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝笔画图radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
