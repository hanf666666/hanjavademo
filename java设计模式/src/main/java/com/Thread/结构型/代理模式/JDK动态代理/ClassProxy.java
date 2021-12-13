package com.Thread.�ṹ��.����ģʽ.JDK��̬����;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1����:
 * 1.Ĭ�ϴ�����ʵ��ProductService ��jdk��̬������InvocationHandler
 * 2����
 * 1.Ĭ�ϴ�����ʵ��ProductService ��jdk��̬������ ʲô�඼���Դ���Proxy
 *
 */
public class ClassProxy implements InvocationHandler{
    Object targetService;

    public ClassProxy(Object targetService) {
        this.targetService=targetService;

    }


    // 2���ṩ�����������ķ���
    public Object createProxy() {
        //�������
        //Ŀ����
        //�ص�����,��ǿ����
        return Proxy.newProxyInstance(targetService.getClass().getClassLoader(),
                targetService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("��¼��־��" + method.getName() + "������ִ����...");
        return method.invoke(targetService, args);
    }




}
