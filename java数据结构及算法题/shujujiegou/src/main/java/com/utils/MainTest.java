package com.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * to do
 *
 * @author Hj
 * @date 2022/4/27
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Profiler.start("AAAA");
                Profiler.start("BBBB");
                Profiler.start("CCCC");
                Profiler.start("DDDD");
                Profiler.start("FFFFF");

                Profiler.showTree();
                Profiler.stop();
            }
        });



    }
}
