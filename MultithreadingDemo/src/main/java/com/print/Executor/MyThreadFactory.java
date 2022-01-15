package com.print.Executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *
 * @author Hj
 * @date 2021/9/8
 */
class MyThreadFactory implements ThreadFactory {
    AtomicInteger atomic = new AtomicInteger();

    public MyThreadFactory() {

    }

    public Thread newThread(Runnable r) {
        SecurityManager s = new SecurityManager();
        // 线程组是为了更加安全
        ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        Thread thread = new Thread(group, r);
        thread.setName("任务线程-" + atomic.incrementAndGet());
        return thread;
    }

}
