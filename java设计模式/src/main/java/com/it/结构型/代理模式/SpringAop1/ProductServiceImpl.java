package com.it.结构型.代理模式.SpringAop1;

public class ProductServiceImpl implements ProductService {

    @Override
    public void add() {
        System.out.println("添加商品...");
    }

    @Override
    public void edit() {
        System.out.println("修改商品...");
    }

    @Override
    public void delete() {
        System.out.println("删除商品...");
    }

    @Override
    public void query() {
        System.out.println("查询商品...");
    }
}
