package com.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池工具类
 *
 * @author Hj
 */
public class ThreadPoolUtil {
    private static ThreadPoolExecutor executor;

    /**
     * 创建线程池
     */
    public static void createThread() {
        // executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        // //无界限线程池
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20); // 固定个数线程
    }

    /**
     * 执行线程
     *
     * @param task
     */
    public static void run(Runnable task) {
        // System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
//		executor.submit(task);
        // System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        // System.out.printf("Server: Active Count: %d\n",
        // executor.getActiveCount());
        // System.out.printf("Server: Completed Tasks: %d\n",
        // executor.getCompletedTaskCount());
    }

    /**
     * 执行线程
     *
     * @param task
     */
    public static Future submit(Runnable task) {
        // System.out.printf("Server: A new task has arrived\n");
//		executor.execute(task);
        Future future = executor.submit(task);
        // System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        // System.out.printf("Server: Active Count: %d\n",
        // executor.getActiveCount());
        // System.out.printf("Server: Completed Tasks: %d\n",
        // executor.getCompletedTaskCount());
//		try {
//			Thread.sleep(5000);
//			if(!future.isDone())
//				System.out.println("task 正在进行");
//			else {
//				System.out.println("task 执行结束!");
//			}
//			future.get();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
        return future;

    }

    /**
     * 强制关闭线程池
     */
    public static void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolUtil.createThread();
        List<Object> list = new ArrayList<>();
        TaskTread taskTread = new TaskTread(list);
        ThreadPoolUtil.submit(taskTread);
        System.out.println(list.get(0));
        ThreadPoolUtil.shutdown();
    }
}
