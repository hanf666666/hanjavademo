package com.it.DesignPattern.结构型.代理模式.JDK动态代理;



public class MainJdkProxy {
    public static void main(String[] args) {
       ProductService productService = new ProductServiceImpl();
        ClassProxy classProxy = new ClassProxy(productService);
        ProductService productServiceproxy = (ProductService) classProxy.createProxy();

        productServiceproxy.add();
        productServiceproxy.edit();
    }
}
