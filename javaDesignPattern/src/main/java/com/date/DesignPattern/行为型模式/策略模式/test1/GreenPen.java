package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test1;


public class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("����ɫ�ʻ�ͼradius:" + radius + ", x:" + x + ", y:" + y);
    }
}
