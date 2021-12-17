package com.it.DesignPattern.结构型.装饰模式;

public class Blacktea extends AbstactBeverage {
    @Override
    protected String getDescription() {
        return "???";
    }

    @Override
    protected Double cost() {
        return new Double(10);
    }
}
