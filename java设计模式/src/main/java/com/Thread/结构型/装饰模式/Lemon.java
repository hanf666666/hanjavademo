package com.Thread.�ṹ��.װ��ģʽ;

public class Lemon extends AbstractCondiment {
    AbstactBeverage abstactBeverage;

    public Lemon(AbstactBeverage abstactBeverage) {
        this.abstactBeverage=  abstactBeverage;
    }

    @Override
    protected String getDescription() {
        return abstactBeverage.getDescription()+"������";
    }

    @Override
    protected Double cost() {
        return abstactBeverage.cost()+11;
    }
}
