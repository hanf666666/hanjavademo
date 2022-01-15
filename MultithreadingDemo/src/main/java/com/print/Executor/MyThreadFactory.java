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
        // �߳�����Ϊ�˸��Ӱ�ȫ
        ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        Thread thread = new Thread(group, r);
        thread.setName("�����߳�-" + atomic.incrementAndGet());
        return thread;
    }

}
