package com.date.DesignPattern.结构型.桥梁模式.demo01;

public class BluePen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("??BluePen?????radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
