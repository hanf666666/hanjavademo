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
        //创建一个核心线程数为1，最大线程数为3，大小为1的队列的线程池

        final MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                0,
                3,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10)
        );


        /**
         * 提交5个任务，这个任务睡眠两秒后打印当前的线程和任务名
         */
        for (int j = 0; j < 5; j++) {
            String taskname = "test: run task" + j;
            myThreadPoolExecutor.submit(() -> {
                System.out.println("启动线程："+Thread.currentThread().getName() + taskname + " 逻辑处理start");
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
