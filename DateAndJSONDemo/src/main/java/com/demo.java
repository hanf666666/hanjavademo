package com;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.HashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/27
 */
public class demo {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>(3333333);
         stringStringHashMap.put("k", "v");
        stringStringHashMap.put("k2", "v");
        stringStringHashMap.put("k3", "v");
         int MAXIMUM_CAPACITY = 1 << 30;
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(1/0);

    }
}
