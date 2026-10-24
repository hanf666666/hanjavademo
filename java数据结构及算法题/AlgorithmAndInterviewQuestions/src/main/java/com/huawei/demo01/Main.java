package com.huawei.demo01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Long s = scanner.nextLong();
            HashSet<Long> longs = new HashSet<>();
            for (int i = 0; i < s; i++) {

                Long aa = scanner.nextLong();
                longs.add(aa);
            }
        System.out.println();
            longs.stream().sorted(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return o2.compareTo(o1);
//                    return o1.compareTo(o2);
                }
            }).forEach(row -> {
                        System.out.println(row);
                    }

            );

//            longs.toArray()
        Long[] array = longs.toArray(new Long[0]);

        Arrays.stream(array).sorted(Comparator.comparingLong(new ToLongFunction<Long>() {
            @Override
            public long applyAsLong(Long value) {
                return value;
            }
        }).reversed());
        System.out.println();
        Arrays.sort(array,Comparator.reverseOrder());
        System.out.println();

        System.out.println(Arrays.toString(array));
        Arrays.stream(array).forEach(System.out::println);



        }


    }

