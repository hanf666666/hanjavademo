package com.orders;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        // 初始乱序列表
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 5));
        System.out.println("原始列表: " + list + "\n");

        // ---------------------------------------------------------
        // 场景 1：降序排列 (b - a)
        // ---------------------------------------------------------
        System.out.println("=== 场景 1：降序排列，代码为 (a, b) -> b - a ===");
        Collections.sort(list, (a, b) -> {
            int result = b - a;

            // 打印底层比较日志
            String action = result > 0 ? "【正数 -> 交换】" : (result < 0 ? "【负数 -> 不换】" : "【相等】");
            System.out.printf("机器人比较: a(前面)=%d, b(后面)=%d | 计算: %d - %d = %d %s%n",
                    a, b, b, a, result, action);

            return result;
        });
        System.out.println("降序结果: " + list + "\n");


        // ---------------------------------------------------------
        // 场景 2：升序排列 (a - b)
        // ---------------------------------------------------------
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 1, 5));
        System.out.println("=== 场景 2：升序排列，代码为 (a, b) -> a - b ===");
        Collections.sort(list2, (a, b) -> {
            int result = a - b;

            String action = result > 0 ? "【正数 -> 交换】" : (result < 0 ? "【负数 -> 不换】" : "【相等】");
            System.out.printf("机器人比较: a(前面)=%d, b(后面)=%d | 计算: %d - %d = %d %s%n",
                    a, b, a, b, result, action);

            return result;
        });
        System.out.println("升序结果: " + list2);
    }
}
