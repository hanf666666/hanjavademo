package com.date.DesignPattern.结构型.代理模式.SpringAop1;

public class CustomerServiceImpl {
    public int save() {
        System.out.println("??????");
        return 1;
    }

    public void update() {
        System.out.println("?????");
    }

    public void delete() {
        System.out.println("??????");
    }

    public void search() {
        System.out.println("??????");
    }


}
