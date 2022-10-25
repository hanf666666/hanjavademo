package com.date.utils;


import cn.hutool.core.date.StopWatch;


/**
 * to do
 *
 * @author Hj
 * @date 2022/10/19
 */
public class StopWatchMain {
    public static void main(String[] args) throws InterruptedException {

        // 只输出运行多少秒
        StopWatch stopwatch = StopWatch.create("id");
        stopwatch.start("task1");
        stopwatch.stop();
        stopwatch.start("task1");
        // do something
        Thread.sleep(1000);
        stopwatch.stop();

        System.out.println(stopwatch.prettyPrint());


        try {
            int i = 1 / 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("=====================");
        }


    }
}
