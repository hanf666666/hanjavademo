package com.Thread.Lambda.news;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * to do
 *只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。

 * @author Hj
 * @date 2021/12/1
 */
public class maintest2 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("2peter", "1anna", "3mike", "4xenia");
        System.out.println(stringList);
        //接口实现简写==>方法的参数->返回值
        Collections.sort(stringList, (String a, String b) -> b.compareTo(a));
        Collections.sort(stringList, ( a, b) -> b.compareTo(a));
        System.out.println(stringList);



    }
}
