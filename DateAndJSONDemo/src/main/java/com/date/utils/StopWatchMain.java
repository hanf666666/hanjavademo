package com.date.utils;


import cn.hutool.core.date.StopWatch;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


/**
 * to do
 *
 * @author Hj
 * @date 2022/10/19
 */
public class StopWatchMain {
    public static void main(String[] args) throws InterruptedException {

        // ֻ������ж�����
        StopWatch stopwatch = StopWatch.create("id");
        stopwatch.start("task1");
        stopwatch.stop();
        stopwatch.start("task1");
        // do something
        Thread.sleep(1000);
        stopwatch.stop();

//        System.out.println(stopwatch.prettyPrint());
        System.out.println(stopwatch.prettyPrint(TimeUnit.SECONDS));
//        System.out.println(stopwatch.getLastTaskTimeMillis());
        String momRatio = String.format("%.2f", (10898 * 1.00 / 10898 - 1) * 100);
        String momRatio2 = String.format("%.2f", (10898 * 1.0 / 10898 - 1) * 100);
        System.out.println(momRatio);
        long l = (long) 1.111;
        System.out.println(l);
         l =40425L;
        String format = NumberFormat.getIntegerInstance(Locale.getDefault()).format(l);
        System.out.println(format);
        long l1 = Long.parseLong(format.replaceAll(",",""));
        System.out.println(l1);

        try {
            int i = 1 / 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("=====================");
        }


    }
}
