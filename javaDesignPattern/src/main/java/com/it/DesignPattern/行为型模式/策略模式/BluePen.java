package com.it.DesignPattern.��Ϊ��ģʽ.����ģʽ;


public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("???????????radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
