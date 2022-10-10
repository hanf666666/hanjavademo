package com.newsfeatures.Stream.collect;

import cn.hutool.Hutool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest2 {
    public static void main(String[] args) {
        List<Map<String, String>> stringArrayList = new ArrayList<>();
        HashMap map1 = new HashMap<>();
        map1.put("age", "1");
        map1.put("name", "hanjing1");
        stringArrayList.add(map1);

        HashMap map2 = new HashMap<>();
        map2.put("age", "2");
        map2.put("name", "hanjing2");
        stringArrayList.add(map2);

        List<String> collect = stringArrayList.stream().map(map -> map.get("age")).collect(Collectors.toList());
        System.out.println(collect);
    }
}
