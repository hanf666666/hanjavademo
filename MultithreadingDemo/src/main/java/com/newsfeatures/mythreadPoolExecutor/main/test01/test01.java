package com.newsfeatures.mythreadPoolExecutor.main.test01;

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
public class test01 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        String threadName = "thread_data_=>" + i.incrementAndGet();
        //����һ�������߳���Ϊ1������߳���Ϊ3����СΪ1�Ķ��е��̳߳�

        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                3,
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
//                log.info("���������Ĭ���߳���={}",Thread.currentThread().getName());
//                Thread.currentThread().setName(taskname);
//                log.info("����������޸ĵ��߳���={}��ʼ",Thread.currentThread().getName());
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                log.info("����������޸ĵ��߳���={}��������Ȼ��,����",Thread.currentThread().getName());

            });
        }
    }
}
