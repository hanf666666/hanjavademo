package com.date.DesignPattern.行为型模式.策略模式.test2;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public class AliPayStrategy implements Strategy {
    @Override
    public String operate() {
        System.out.println("AliPayStrategy");
        return "AliPayStrategy";
    }
}
