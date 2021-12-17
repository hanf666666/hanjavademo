package com.it.DesignPattern.结构型.代理模式.SpringAop2;

public class ProductServiceImpl implements ProductService {

    @Override
    public void add() {
        System.out.println("??????...");
    }

    @Override
    public void edit() {
        System.out.println("??????...");
    }

    @Override
    public void delete() {
        System.out.println("??????...");
    }

    @Override
    public void query() {
        System.out.println("??????...");
    }
}
