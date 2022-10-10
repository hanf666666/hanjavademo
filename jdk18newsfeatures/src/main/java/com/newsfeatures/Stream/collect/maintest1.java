package com.newsfeatures.Stream.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        List<Student> stringArrayList = new ArrayList<>();
        stringArrayList.add(new Student("hanjing1","1L"));
        stringArrayList.add(new Student("hanjing2","2L"));
        stringArrayList.add(new Student("hanjing3","3L"));
        List<String> collect = stringArrayList.stream().map(map -> map.getName()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
