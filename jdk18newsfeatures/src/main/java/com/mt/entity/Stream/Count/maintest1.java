package com.mt.entity.Stream.Count;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("ddd2");
        stringArrayList.add("aaa2");
        stringArrayList.add("bbb1");
        stringArrayList.add("aaa1");
        stringArrayList.add("bbb3");
        stringArrayList.add("ccc");
        stringArrayList.add("bbb2");
        stringArrayList.add("ddd1");
        long startsWithB =
                stringArrayList
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB);    // 3
    }
}
