package com.Thread.Executor.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/3
 */
public class FixedThreadPool_demo {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(30);
        executorService.submit(new MyCallable());
        executorService.submit(new MyCallable());
    }
}
