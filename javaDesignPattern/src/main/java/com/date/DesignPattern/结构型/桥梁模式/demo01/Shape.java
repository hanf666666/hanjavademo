package com.date.DesignPattern.结构型.桥梁模式.demo01;

public abstract class Shape {
    //????????????????????,????????????
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();

}
