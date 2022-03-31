package com.newsfeatures.Optional.filterdemo;


import com.newsfeatures.Optional.filterdemo.entity.UserHHHH;
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
public class filterdemo3 {
    @Test
    public  void test() {
        ArrayList<UserHHHH> integersArrayList = new ArrayList<UserHHHH>();
        integersArrayList.add(new UserHHHH("aa","11"));
        integersArrayList.add(new UserHHHH("bb","22"));
        integersArrayList.add(new UserHHHH("cc","33"));
        integersArrayList.add(new UserHHHH("dd","44"));

        Stream<UserHHHH> integerStream = integersArrayList.parallelStream().filter(i -> i.getName().equals("55"));

//        Optional<UserHHHH> first = integerStream.findFirst();
//        System.out.println(first.get());
//        Optional<UserHHHH> first = integerStream.findFirst();

        long count = integerStream.count();
        System.out.println(count);

    }
}
