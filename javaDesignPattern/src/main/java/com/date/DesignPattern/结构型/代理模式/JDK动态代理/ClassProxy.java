package com.date.DesignPattern.结构型.代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 */
public class ClassProxy implements InvocationHandler {
    Object targetService;

    public ClassProxy(Object targetService) {
        this.targetService = targetService;

    }
    public Object createProxy() {

        return Proxy.newProxyInstance(targetService.getClass().getClassLoader(),
                targetService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("方法调用==>" + method.getName() );
        return method.invoke(targetService, args);
    }


}
