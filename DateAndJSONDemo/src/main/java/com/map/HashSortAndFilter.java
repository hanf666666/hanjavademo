package com.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Hj
 * @date 2025/12/9
 */

public class HashSortAndFilter {
    public static void main(String[] args) {
        Map<Object, Integer> map = new HashMap<>();
        map.put("a", 3);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 4);

        // 按值排序并过滤
        Map<Object, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(entry -> (int) entry.getValue() >= 2) // 过滤值大于2的项
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // 处理键冲突（保留原值）
                        LinkedHashMap::new // 保持排序顺序
                ));

        System.out.println(sortedMap);



  /*      Map<String, Integer> map1 = Map.of("a", 3, "b", 1);
        Map<String, Integer> map2 = Map.of("a", 2, "b", 4, "c", 5);
        Map<String, Integer> result = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a + b,
                        LinkedHashMap::new
                ));
//        System.out.println(result); // {a=5, b=5, c=5}
*/

    }
}


