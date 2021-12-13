package com.it.结构型.桥梁模式.demo01;

public abstract class Shape {
    //抽象类可以引入属性变量,这是接口不具备的
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();

}
