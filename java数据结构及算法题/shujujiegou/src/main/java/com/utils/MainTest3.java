package com.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * to do
 * jmap -dump:format=b,file=./dumpfasdf.hprof 18060
 *
 * @author Hj
 * @date 2022/4/27
 */
public class MainTest3 {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        rundemo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }


    }

    private static void rundemo() throws InterruptedException {
        Profiler.start("AAAA");
        Thread.sleep(1000);
        Profiler.start("BBBB");
        Thread.sleep(2000);
        Profiler.start("CCCC");
        Thread.sleep(4000);
        Profiler.start("DDDD");
        Thread.sleep(8000);
        Profiler.start("FFFFF");
        Profiler.stop();
        Profiler.showTree();
    }
}
