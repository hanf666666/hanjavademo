package com.newsfeatures.mythreadPoolExecutor.main.test02;

import com.newsfeatures.mythreadPoolExecutor.utils.MyThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/13
 */
@Slf4j
public class test02 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        String threadName = "thread_data_=>" + i.incrementAndGet();
        //����һ�������߳���Ϊ1������߳���Ϊ3����СΪ1�Ķ��е��̳߳�

        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                1,
                3,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10)
        );



        /**
         * �ύ5�������������˯��������ӡ��ǰ���̺߳�������
         */
        for (int j = 1; j <= 5; j++) {
            String taskname = "test: run task" + j;
            myThreadPoolExecutor.submit(() -> {
                log.info("��������{}����,���߳�Ϊ{}��ʼ",taskname,Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("��������{}����,���߳�Ϊ{}����",taskname,Thread.currentThread().getName());

            });
        }
    }
}
