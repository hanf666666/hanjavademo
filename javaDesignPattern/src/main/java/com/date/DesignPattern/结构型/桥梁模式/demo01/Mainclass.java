package com.date.DesignPattern.结构型.桥梁模式.demo01;


/**
 * 其实就是理解代码抽象和解耦
 * 笔和形状有关联 需解耦更加形象,灵活
 */
public class Mainclass {
    public static void main(String[] args) {
        Shape greenCircle = new Circle(10, new GreenPen());
          greenCircle.draw();

        Rectangle bluerectangle = new Rectangle(10, new BluePen());
        bluerectangle.draw();
    }
}
