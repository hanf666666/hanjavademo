package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test1;


public class BluePen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("�����ʻ�ͼradius:" + radius + ", x:" + x + ", y:" + y);
    }
}
