package com.date.DesignPattern.结构型.代理模式.SpringAop2;

public class ProductServiceImpl implements ProductService {

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void edit() {
        System.out.println("edit");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void query() {
        System.out.println("query");
    }
}
