package com.date.DesignPattern.结构型.代理模式.默认代理模式.demo01;

public class Chicken extends Food {

    private String   chicken;

    public Chicken() {
        System.out.println("??????chiken??");
    }

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }
}
