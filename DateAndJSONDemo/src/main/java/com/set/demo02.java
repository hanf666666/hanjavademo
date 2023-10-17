package com.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/27
 */
public class demo02 {
    public static void main(String[] args) {
        List<Integer> ids1=new ArrayList<>();
        ids1.add(1);
        ids1.add(3);
        ids1.add(5);

        List<Integer> ids2=new ArrayList<>();
        ids2.add(1);
        ids2.add(2);
//        ids2.add(3);

        // 使用HashSet求差集
        HashSet<Integer> set1 = new HashSet<>(ids1);
        set1.removeAll(ids2);
        // 使用HashSet求差集
        HashSet<Integer> set2 = new HashSet<>(ids2);
        set2.removeAll(ids1);
        // 输出结果
        System.out.println("差集结果：" + set1);
        System.out.println("差集结果：" + set2);

//        System.out.println("差集：" + result);


//        System.out.println("并集：" + result);



    }
}
