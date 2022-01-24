package com.executor.Executor.newFixedThreadPool;

import java.util.concurrent.Callable;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/3
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("线程的名字===>"+Thread.currentThread().getName());
        return null;
    }
}
