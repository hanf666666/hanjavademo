package com.mt.entity.���̵߳����߳�.Future2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        Future future = executorService.submit(t);//���߳�����
        try {
            future.get();//��Ҫ���������쳣
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
        executorService.shutdown();

    }
}
