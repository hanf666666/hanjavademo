package com.date.DesignPattern.结构型.代理模式.cglib代理;

public class CustomerServiceImpl {
    public int save() {
        System.out.println("save");
        return 1;
    }

    public void update() {
        System.out.println("update");
    }

    public void delete() {
        System.out.println("delete");
    }

    public void search() {
        System.out.println("search");
    }


}
