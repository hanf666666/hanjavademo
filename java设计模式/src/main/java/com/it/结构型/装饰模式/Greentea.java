package com.it.结构型.装饰模式;

public class Greentea extends AbstactBeverage {
    @Override
    protected String getDescription() {
        return "绿茶";
    }

    @Override
    protected Double cost() {
        return new Double(200);
    }
}
