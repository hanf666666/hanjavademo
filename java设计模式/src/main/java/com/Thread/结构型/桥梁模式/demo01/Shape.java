package com.Thread.�ṹ��.����ģʽ.demo01;

public abstract class Shape {
    //����������������Ա���,���ǽӿڲ��߱���
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();

}
