package com.date.DesignPattern.结构型.装饰模式;

public class Lemon extends AbstractCondiment {
    AbstactBeverage abstactBeverage;

    public Lemon(AbstactBeverage abstactBeverage) {
        this.abstactBeverage=  abstactBeverage;
    }

    @Override
    protected String getDescription() {
        return abstactBeverage.getDescription()+"加调料 柠檬";
    }

    @Override
    protected Double cost() {
        return abstactBeverage.cost()+11;
    }
}
