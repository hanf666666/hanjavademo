package com.it.结构型.代理模式.cglib代理;

import org.junit.Test;

public class MainCglibProxy {
    @Test
    // 没有代理
    public void testNoProxy() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.save();
        customerService.update();
        customerService.delete();
        customerService.search();
    }

    @Test
    // 测试 cglib代理
    public void testCglibProxy() {
        // 目标
        CustomerServiceImpl target = new CustomerServiceImpl();
        // 生成代理
        CglibProxy factory = new CglibProxy(target);
        CustomerServiceImpl proxy = (CustomerServiceImpl) factory.createProxy();
        // 调用代理对象的方法
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.search();
    }
}
