package com;


import cn.hutool.core.collection.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * to do
 * 账单分割
 *
 * @author Hj
 * @date 2023/7/10
 */
public class splitdemo2 {
    public static void main(String[] args) {
        // 建立一个list
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 12, 14, 64, 674, 6, 43, 43);
        List<Integer> integers = Arrays.asList(1, 2);

// 每4个元素分割为一个list
        List<List<Integer>> partition = ListUtil.partition(integers, 4);
// 遍历每个list
        partition.forEach(list -> {
            System.out.println(list.toString() + " 数量" + list.size());
        });


    }
}

