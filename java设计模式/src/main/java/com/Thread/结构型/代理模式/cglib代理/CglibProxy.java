package com.Thread.�ṹ��.����ģʽ.cglib����;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    // ������Ŀ�����
    private Object target;

    // 1�� ͨ�������������뱻����Ŀ�����
    public CglibProxy(Object target) {
        this.target = target;
    }

    // 2�� �ṩ���ɴ������ķ���
    public Object createProxy() {
        // �������ɴ��� API��
        Enhancer enhancer = new Enhancer();
        // ����Ŀ���࣬�����������������
        enhancer.setSuperclass(target.getClass());
        // ���ûص�����
        enhancer.setCallback(this);
        // ���ɴ�����
        return enhancer.create();
    }

    @Override
    // 3�� ��д�ص����غ���������Ŀ��������з���
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("��¼��־��" + method.getName() + "����������....");
        return methodProxy.invokeSuper(proxy, args);// ���ø��ࣨ��ʵ���󣩵ķ���
        // return method.invoke(target, args);
    }


}
