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
        //创建一个核心线程数为1，最大线程数为3，大小为1的队列的线程池

        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                1,
                3,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10)
        );



        /**
         * 提交5个任务，这个任务睡眠两秒后打印当前的线程和任务名
         */
        for (int j = 1; j <= 5; j++) {
            String taskname = "test: run task" + j;
            myThreadPoolExecutor.submit(() -> {
                log.info("数据任务{}处理,此线程为{}开始",taskname,Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("数据任务{}处理,此线程为{}结束",taskname,Thread.currentThread().getName());

            });
        }
    }
}
