package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ;


public class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("???????????radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
