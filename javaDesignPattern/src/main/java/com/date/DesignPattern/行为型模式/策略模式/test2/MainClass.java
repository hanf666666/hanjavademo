package com.date.DesignPattern.行为型模式.策略模式.test2;

import com.date.DesignPattern.行为型模式.策略模式.test1.Context;
import com.date.DesignPattern.行为型模式.策略模式.test1.GreenPen;

/**
 * 使用 if...else 所带来的复杂和难以维护。
 * 增加类写法
 */
public class MainClass {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext();
        strategyContext.operate(2);
    }
}
