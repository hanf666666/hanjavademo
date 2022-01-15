package com.print.Lambda.old;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * to do
 *只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。
 * 通常做法都是创建一个
 * 匿名的比较器对象然后将其传递给sort方法。
 * @author Hj
 * @date 2021/12/1
 */
public class maintest1 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("2peter", "1anna", "3mike", "4xenia");
        System.out.println(stringList);
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(stringList);



    }
}
