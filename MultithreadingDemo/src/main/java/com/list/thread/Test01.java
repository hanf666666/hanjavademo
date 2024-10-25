package com.list.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ArrayList是线程不安全的,put等在多线程会丢失
 *
 * @author Hj
 * @date 2024/7/23
 */
public class Test01 {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        List<Future> futureList = new ArrayList<>();
        List<Long> synlist = Collections.synchronizedList(new ArrayList<>());
        list.add(-1L);
        synlist.add(-1L);

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (long i = 0; i < 100000; i++) {
            long finalI = i;
            Future<?> submit = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    list.add(finalI);
                    synlist.add(finalI);

                }
            });
            futureList.add(submit);
        }
        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("list.size() = " + list.size());
        System.out.println("synlist.size() = " + synlist.size());
        System.out.println("list.get(0) = " + list.get(0));




    }
}
