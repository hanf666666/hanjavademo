package com.set;

import java.util.HashSet;
import java.util.Set;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/27
 */
public class demo01 {
    public static void main(String[] args) {
        HashSet result = new HashSet<>();
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(3);
        set1.add(5);

        HashSet set2 = new HashSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集：" + result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集：" + result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集：" + result);



    }
}
