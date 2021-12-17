package com.it.DesignPattern.�ṹ��.����ģʽ.demo01;

public class Rectangle extends Shape {

    private int radius;

    public Rectangle(int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
    }

    public void draw() {
        //
        super.drawAPI.draw(radius, 0, 0);
    }
}
