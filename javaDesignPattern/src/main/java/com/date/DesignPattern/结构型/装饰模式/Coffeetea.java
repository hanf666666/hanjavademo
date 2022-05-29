package com.date.DesignPattern.结构型.装饰模式;

public class Coffeetea extends AbstactBeverage {
    @Override
    protected String getDescription() {
        return "咖啡";
    }

    @Override
    protected Double cost() {
        return new Double(2000);
    }
}
