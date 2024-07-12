package com.date.DesignPattern.行为型模式.策略模式.test3;

import com.date.DesignPattern.行为型模式.策略模式.test3.StrategyContext;

/**
 * 使用 if...else 所带来的复杂和难以维护。+hashMap
 * 增加类是大类,方法是小类
 * 支付宝支付和微信支付少可以写一个类 多了再次抽象新的策略类型
 */
public class MainClass {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext();
        String pay = strategyContext.pay(PayTypeEnum.H5);
        System.out.println(pay);
    }
}
