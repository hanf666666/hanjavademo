package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hj
 * @date 2026/9/21
 */
public class HashSortDemo {
    public static void main(String[] args) {
        Map<Object, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 4);
        System.out.println(map.getOrDefault("a", 1)); // 10，存在，返回原值
        System.out.println(map.getOrDefault("e", 1111)); // 1，不存在，返回默认值
        System.out.println("===========================");
        map.merge("e",1,(v1,v2)->v1+v2);
        map.merge("e",1,(v1,v2)->v1+v2);
        map.merge("e",4,(v1,v2)->v1+v2);
        map.merge("e", 1, Integer::sum);
        map.getOrDefault("e", 1);
        map.forEach((k,v)->{
            System.out.println(k+"===========>"+v);
        });
        Map<Object, ArrayList<Long> > map2 = new HashMap<>();

        map2.computeIfAbsent("ff", k -> new ArrayList<>()).add(1111L);
        map2.computeIfAbsent("ff", k -> new ArrayList<>()).add(1111L);
        map2.computeIfAbsent("ff", k -> new ArrayList<>()).add(1111L);
        map2.forEach((k,v)->{
            System.out.println(k+"===========>"+v);
        });
    }
}
