package com.newsfeatures.Executor.newFixedThreadPool;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/3
 */
public class FixedThreadPool_demo2 {

    public static void main(String[] args) {
//            final CountDownLatch count = new CountDownLatch(100);
        //javaµÄÏß³Ì³Ø
        final ExecutorService executorService = Executors.newFixedThreadPool(100);
        ArrayList<Future> futures = new ArrayList<>();

         AtomicReference<Long> j = new AtomicReference<>(new Long(0));
        System.out.println(j);
        Future<?> submit = executorService.submit(() -> {
            Long aaa=222L;
            j.set(aaa);
            System.out.println(j);
        });
        futures.add(submit);

        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(j);
        System.out.println(new DecimalFormat("000000").format(j.get()));
        executorService.shutdown();

    }

}
