package com.newsfeatures.Lambda.news;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2023/10/8
 */
public class LambdaExample {
    public static void main(String[] args) {

            List<String> stringList = new ArrayList<>();
        int i1 = 1 / 0;

        stringList.add("a");
            stringList.add("b");
            stringList.add("c");
            stringList.add("d");
            final int[] i = {0};
            stringList.forEach(s -> {
                System.out.println(s + i[0]);
                i[0] = i[0] + 1;
            });

    }
}