package com.base.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * �̳߳ع�����
 *
 * @author Hj
 */
public class ThreadPoolUtil {
    private static ThreadPoolExecutor executor;

    /**
     * �����̳߳�
     */
    public static void createThread() {
        // executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        // //�޽����̳߳�
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20); // �̶������߳�
    }

    /**
     * ִ���߳�
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
     * ִ���߳�
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
//				System.out.println("task ���ڽ���");
//			else {
//				System.out.println("task ִ�н���!");
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
     * ǿ�ƹر��̳߳�
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
