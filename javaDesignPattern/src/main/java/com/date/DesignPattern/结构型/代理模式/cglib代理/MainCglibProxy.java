package com.date.DesignPattern.�ṹ��.����ģʽ.cglib����;

import org.junit.Test;

public class MainCglibProxy {
    @Test
    // ??��???
    public void testNoProxy() {
       CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.save();
        customerService.update();
        customerService.delete();
        customerService.search();
    }

    @Test
    // ???? cglib????
    public void testCglibProxy() {
        // ???
        com.date.DesignPattern.�ṹ��.����ģʽ.SpringAop2.CustomerServiceImpl target = new com.date.DesignPattern.�ṹ��.����ģʽ.SpringAop2.CustomerServiceImpl();
        // ???????
        CglibProxy factory = new CglibProxy(target);
       CustomerServiceImpl proxy = (CustomerServiceImpl) factory.createProxy();
        // ??????????????
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.search();
    }
}
