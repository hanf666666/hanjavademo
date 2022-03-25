package com.AtomicAndVolatile;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/25
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

// 不保证原子性
public class AtomicIntegerDemo2 {


    public static void add(AtomicInteger num,int num2) {

//        num.getAndIncrement();// AtomicInteger+1 方法 CAS
          num.getAndAdd(num2);
    }

    public static void main(String[] args) {
        AtomicInteger numCount = new AtomicInteger();
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

