package com.newsfeatures.mythreadPoolExecutor.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/14
 */
@Slf4j
public class MyDefaultThreadFactory implements ThreadFactory {
    //���ӱ��Ϊ1
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    MyDefaultThreadFactory() {
        log.info("�̹߳���ʵ������MyDefaultThreadFactory");
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "pool-" +
                poolNumber.getAndIncrement() +
                "-thread-";
    }

    public Thread newThread(Runnable r) {

        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        log.info("MyDefaultThreadFactory���̴���һ���߳�Ϊ==>��{},����{}",group, t.getName());
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}