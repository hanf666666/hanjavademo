package com.Thread.��Ϊ��ģʽ.����ģʽ;


public class GreenPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("����ɫ�ʻ�ͼ��radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
