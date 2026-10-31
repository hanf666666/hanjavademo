package com.javaheap.demo03ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateFormatDemo {

    // 用 withInitial 提供初始值，省去判空
    private static final ThreadLocal<SimpleDateFormat> SDF =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    static SimpleDateFormat aaa=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 6; i++) {
            final int id = i;
            pool.submit(() -> {
                try {
//                    String now = SDF.get().format(new Date());
                    while (true){
                        String now = aaa.format(new Date());
                        System.out.println(Thread.currentThread().getName()
                                + " 任务" + id + " -> " + now);
//                        Thread.sleep(100);
                    }

                } finally {
                    SDF.remove();   // 线程池必做
                }
            });
        }
        pool.shutdown();
    }
}
