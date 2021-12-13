package com.it.结构型.代理模式.cglib代理;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    // 被代理目标对象
    private Object target;

    // 1、 通过构造器，传入被代理目标对象
    public CglibProxy(Object target) {
        this.target = target;
    }

    // 2、 提供生成代理对象的方法
    public Object createProxy() {
        // 用于生成代理 API类
        Enhancer enhancer = new Enhancer();
        // 设置目标类，根据类生成子类代理
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 生成代理返回
        return enhancer.create();
    }

    @Override
    // 3、 编写回调拦截函数，拦截目标对象所有方法
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("记录日志：" + method.getName() + "方法被调用....");
        return methodProxy.invokeSuper(proxy, args);// 调用父类（真实对象）的方法
        // return method.invoke(target, args);
    }


}
