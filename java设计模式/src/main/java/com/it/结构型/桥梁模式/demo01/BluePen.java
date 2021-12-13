package com.it.结构型.桥梁模式.demo01;

public class BluePen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用BluePen画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
