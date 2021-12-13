package com.Thread.Stream.并行Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> valueList = new ArrayList<>(max);
        long t1 = System.nanoTime();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            valueList.add(uuid.toString());
        }
        long t2 = System.nanoTime();
        long millis1 = TimeUnit.NANOSECONDS.toMillis(t2 - t1);

        System.out.println(String.format("传统parallel sort took: %d ms", millis1));


        long t3 = System.nanoTime();
        long count = valueList.parallelStream().sorted().count();
        System.out.println(count);
        long t4 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(t3 - t4);
        System.out.println(String.format("流式并行parallel sort took: %d ms", millis2));



    }
}
