package com.Thread.�ṹ��.����ģʽ.cglib����;

import org.junit.Test;

public class MainCglibProxy {
    @Test
    // û�д���
    public void testNoProxy() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.save();
        customerService.update();
        customerService.delete();
        customerService.search();
    }

    @Test
    // ���� cglib����
    public void testCglibProxy() {
        // Ŀ��
        CustomerServiceImpl target = new CustomerServiceImpl();
        // ���ɴ���
        CglibProxy factory = new CglibProxy(target);
        CustomerServiceImpl proxy = (CustomerServiceImpl) factory.createProxy();
        // ���ô������ķ���
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.search();
    }
}
