package com.it.DesignPattern.��Ϊ��ģʽ.����ģʽ;

public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new BluePen()); // ????????????
        context.executeDraw(10, 0, 0);
    }
}
