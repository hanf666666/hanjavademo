package com.newsfeatures.Executor.demo;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2022/5/17
 */
public class asdfasdf {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        for (int i = 1; i < 11; i++) {
            strings.add(i + "");
            if (strings.size() > 3) {
                strings.forEach(row -> {
                    System.out.println("PI"+row);
                });
                strings.clear();
            }else{
                scheduledThreadPool.schedule(new Runnable() {
                    @Override
                    public void run() {
                        if (strings.size() > 0) {
                            strings.forEach(row -> {

                                System.out.println(Thread.currentThread()+"定时任务===>"+row);

                            });
                            strings.clear();
                        } else {
                            System.out.println("空跑");
                        }

                    }
                }, 3, TimeUnit.SECONDS);
            }





        }
    }
}
