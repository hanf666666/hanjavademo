package com.it.DesignPattern.�ṹ��.����ģʽ.demo01;



public class Mainclass {
    public static void main(String[] args) {
        Shape greenCircle = new Circle(10, new GreenPen());
          greenCircle.draw();

        Rectangle bluerectangle = new Rectangle(10, new BluePen());
        bluerectangle.draw();
    }
}
