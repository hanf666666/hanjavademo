package com.it.结构型.代理模式.cglib代理;

public class CustomerServiceImpl {
    public int save() {
        System.out.println("保存客户");
        return 1;
    }

    public void update() {
        System.out.println("修改客户");
    }

    public void delete() {
        System.out.println("删除客户");
    }

    public void search() {
        System.out.println("查询客户");
    }


}
