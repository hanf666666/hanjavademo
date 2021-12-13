package com.Thread.�ṹ��.����ģʽ.SpringAop1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnVal = invocation.proceed(); // ִ��Ŀ�귽��
        long end = System.currentTimeMillis();
        System.out.println("=====================================");
        System.out.println("�� :" + invocation.getThis().getClass().getSimpleName());
        System.out.println("����:" + invocation.getMethod().getName());
        System.out.println("��ʱ:" + (end-start) + "����!");
        System.out.println("=====================================");
        return returnVal;

    }
}
