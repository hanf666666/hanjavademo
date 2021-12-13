package com.Thread.Executor;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/8
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executorfactory {
    public static  Executorfactory factory = new Executorfactory();
    private ExecutorService executors;

    private Executorfactory() {
        // TODO Auto-generated constructor stub
    }
    public static Executorfactory getFactory() {
        return factory;
    }

    public ExecutorService createSingePool() {
        executors = Executors.newSingleThreadExecutor(new MyThreadFactory());
        return executors;
    }

    /**
     * 无界队列，内部使用同步阻塞队列
     *
     * @return
     */
    public ExecutorService createCachePool() {
//        Executors.
        executors = Executors.newCachedThreadPool(new MyThreadFactory());
        return executors;
    }

    /**
     * 产生固定线程数的线程管理器
     *
     * @param count
     * @return
     */
    public ExecutorService createFixedPool(int count) {
        executors = Executors.newFixedThreadPool(count);
        return executors;
    }

    /**
     * 构建带有延迟，周期功能的线程管理器
     *
     * @return
     */
    public ExecutorService createScheduledPool() {
        // cpu数目
        int cpu = Runtime.getRuntime().availableProcessors();
        executors = Executors.newScheduledThreadPool(cpu * 10, new MyThreadFactory());
        return executors;
    }



}

