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
     * �޽���У��ڲ�ʹ��ͬ����������
     *
     * @return
     */
    public ExecutorService createCachePool() {
//        Executors.
        executors = Executors.newCachedThreadPool(new MyThreadFactory());
        return executors;
    }

    /**
     * �����̶��߳������̹߳�����
     *
     * @param count
     * @return
     */
    public ExecutorService createFixedPool(int count) {
        executors = Executors.newFixedThreadPool(count);
        return executors;
    }

    /**
     * ���������ӳ٣����ڹ��ܵ��̹߳�����
     *
     * @return
     */
    public ExecutorService createScheduledPool() {
        // cpu��Ŀ
        int cpu = Runtime.getRuntime().availableProcessors();
        executors = Executors.newScheduledThreadPool(cpu * 10, new MyThreadFactory());
        return executors;
    }



}

