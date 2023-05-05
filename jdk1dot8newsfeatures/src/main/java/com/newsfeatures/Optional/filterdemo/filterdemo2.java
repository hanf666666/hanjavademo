package com.newsfeatures.Optional.filterdemo;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class filterdemo2 {
    @Test
    public  void test() {
        ArrayList<Integer> integersArrayList = new ArrayList<>();
        integersArrayList.add(1);
        integersArrayList.add(2);
        integersArrayList.add(3);
        integersArrayList.add(4);
        integersArrayList.add(5);
        Stream<Integer> integerStream = integersArrayList.parallelStream().filter(i -> i > 3);
        Optional<Integer> first = integerStream.findFirst();
        System.out.println(first.get());
    }
}
