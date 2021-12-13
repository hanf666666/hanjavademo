package com.it.结构型.代理模式.默认代理模式.demo01;

public class Chicken extends Food {

    private String   chicken;

    public Chicken() {
        System.out.println("正制作chiken中");
    }

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }
}
