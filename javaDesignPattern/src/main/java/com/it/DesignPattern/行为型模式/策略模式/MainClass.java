package com.it.DesignPattern.行为型模式.策略模式;

public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new BluePen()); // ????????????
        context.executeDraw(10, 0, 0);
    }
}
