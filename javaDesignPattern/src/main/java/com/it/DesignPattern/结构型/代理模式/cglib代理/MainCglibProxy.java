package com.it.DesignPattern.结构型.代理模式.cglib代理;

import org.junit.Test;

public class MainCglibProxy {
    @Test
    // ??д???
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
        com.it.DesignPattern.结构型.代理模式.SpringAop2.CustomerServiceImpl target = new com.it.DesignPattern.结构型.代理模式.SpringAop2.CustomerServiceImpl();
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
