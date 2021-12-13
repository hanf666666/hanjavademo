package com.Thread.�ṹ��.����ģʽ.JDK��̬����;

public class MainJdkProxy {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        ClassProxy classProxy = new ClassProxy(productService);
        ProductService productServiceproxy = (ProductService) classProxy.createProxy();

        productServiceproxy.add();
        productServiceproxy.edit();
    }
}
