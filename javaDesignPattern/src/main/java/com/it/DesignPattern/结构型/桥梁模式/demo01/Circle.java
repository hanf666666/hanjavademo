package com.it.DesignPattern.结构型.桥梁模式.demo01;

public class Circle extends Shape {


    private int radius;

    public Circle(int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
    }

    public void draw() {
        drawAPI.draw(radius, 0, 0);
    }
}
