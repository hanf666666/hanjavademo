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
        //创建一个核心线程数为1，最大线程数为3，大小为1的队列的线程池

        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                3,
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
//                log.info("数据任务的默认线程名={}",Thread.currentThread().getName());
//                Thread.currentThread().setName(taskname);
//                log.info("数据任务的修改的线程名={}开始",Thread.currentThread().getName());
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                log.info("数据任务的修改的线程名={}处理数据然后,结束",Thread.currentThread().getName());

            });
        }
    }
}
