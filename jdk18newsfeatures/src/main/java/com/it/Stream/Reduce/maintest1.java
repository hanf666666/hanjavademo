package com.it.Stream.Reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<String> reduced =
                stringArrayList
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }
}
