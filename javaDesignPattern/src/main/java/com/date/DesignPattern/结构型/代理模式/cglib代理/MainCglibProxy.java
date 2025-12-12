package com.date.DesignPattern.结构型.代理模式.cglib代理;

import org.junit.Test;

public class MainCglibProxy {
    @Test
    public void testNoProxy() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.save();
        customerService.update();
        customerService.delete();
        customerService.search();
    }

    @Test
    public void testCglibProxy() {
        CustomerServiceImpl target =new CustomerServiceImpl();
        CglibProxy factory = new CglibProxy(target);
        //com.date.DesignPattern.结构型.代理模式.SpringAop2.CustomerServiceImpl$$EnhancerByCGLIB$$e9ac5253@27fe3806
        CustomerServiceImpl proxy = (CustomerServiceImpl) factory.createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.search();
    }
}
