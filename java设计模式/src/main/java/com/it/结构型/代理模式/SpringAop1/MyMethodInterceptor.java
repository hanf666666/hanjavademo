package com.it.结构型.代理模式.SpringAop1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnVal = invocation.proceed(); // 执行目标方法
        long end = System.currentTimeMillis();
        System.out.println("=====================================");
        System.out.println("类 :" + invocation.getThis().getClass().getSimpleName());
        System.out.println("方法:" + invocation.getMethod().getName());
        System.out.println("耗时:" + (end-start) + "毫秒!");
        System.out.println("=====================================");
        return returnVal;

    }
}
