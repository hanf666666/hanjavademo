package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test1;

public class RedPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("�ú�ɫ�ʻ�ͼradius:" + radius + ", x:" + x + ", y:" + y);
    }
}
