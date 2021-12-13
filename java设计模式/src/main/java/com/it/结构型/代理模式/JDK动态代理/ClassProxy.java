package com.it.结构型.代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1方面:
 * 1.默认代理是实现ProductService 和jdk动态代理是InvocationHandler
 * 2方面
 * 1.默认代理是实现ProductService 和jdk动态代理是 什么类都可以代理Proxy
 *
 */
public class ClassProxy implements InvocationHandler{
    Object targetService;

    public ClassProxy(Object targetService) {
        this.targetService=targetService;

    }


    // 2、提供创建代理对象的方法
    public Object createProxy() {
        //类加载器
        //目标类
        //回调函数,增强代码
        return Proxy.newProxyInstance(targetService.getClass().getClassLoader(),
                targetService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("记录日志：" + method.getName() + "方法被执行了...");
        return method.invoke(targetService, args);
    }




}
