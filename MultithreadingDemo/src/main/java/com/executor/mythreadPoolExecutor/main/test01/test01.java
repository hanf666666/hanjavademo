package com.executor.mythreadPoolExecutor.main.test01;

import com.executor.mythreadPoolExecutor.utils.MyBlockingQueue;
import com.executor.mythreadPoolExecutor.utils.MyThreadPoolExecutor;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/13
 */
public class test01 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        String threadName = "thread_data_=>" + i.incrementAndGet();
        //����һ�������߳���Ϊ1������߳���Ϊ3����СΪ1�Ķ��е��̳߳�

        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                0,
                3,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10)
        );


        /**
         * �ύ5�������������˯��������ӡ��ǰ���̺߳�������
         */
        for (int j = 0; j < 5; j++) {
            String taskname = "test: run task" + j;
            myThreadPoolExecutor.submit(() -> {
                System.out.println("�����̣߳�"+Thread.currentThread().getName() + taskname + " �߼�����start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + taskname + " end");

            });
        }
    }
}
