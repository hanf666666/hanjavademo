package com.AtomicAndVolatile;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/25
 */
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// 不保证原子性
public class AtomicLongDemo2 {


    public static void add(AtomicLong num,int num2) {

//        num.getAndIncrement();// AtomicInteger+1 方法 CAS
          num.getAndAdd(num2);
    }

    public static void main(String[] args) {
        final AtomicLong numCount = new AtomicLong(0L);
        ArrayList<Integer> integersList = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            integersList.add(1000);

        }
        integersList.parallelStream().forEach(num->{
            add(numCount,num);
        });
        System.out.println("num=" + numCount);
    }

}

