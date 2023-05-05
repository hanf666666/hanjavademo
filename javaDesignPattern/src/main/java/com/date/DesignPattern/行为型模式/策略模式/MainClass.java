package com.date.DesignPattern.行为型模式.策略模式;

/**
 * 使用 if...else 所带来的复杂和难以维护。
 */
public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new GreenPen()); // 使用绿色笔来画
        context.executeDraw(10, 0, 0);
    }
}
