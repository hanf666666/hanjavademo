package com.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * to do
 *jmap -dump:format=b,file=./dumpfasdf.hprof 18060
 * @author Hj
 * @date 2022/4/27
 */
public class MainTest2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i <2000000 ; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    rundemo();
                }
            });
        }



    }

    private static void rundemo() {
        Profiler.start("AAAA");
        Profiler.start("BBBB");
        Profiler.start("CCCC");
        Profiler.start("DDDD");
        Profiler.start("FFFFF");
        Profiler.stop();
        Profiler.showTree();
    }
}
