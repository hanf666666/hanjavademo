package com.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * to do
 * 贪婪型 占有型 勉强型举例 java
 * @author Hj
 * @date 2024/6/11
 */
public class OtherDemo02 {
    public static void main(String[] args) {
        String test = "a<tr>aava</tr>abb";
        String reg = "<.+>";
        //1. 贪婪型（Greedy） 发现尽可能多的匹配
        System.out.println(test.replaceAll(reg, " #")); // 输出: a #abb

        //2. 勉强型（Reluctant，Lazy） 匹配最小的字符数，也称为懒惰型，最少匹配，非贪婪
        String test2 = "a<tr>aava</tr>abb";
        String reg2 = "<.+?>";
        System.out.println(test.replaceAll(reg2, " #")); // 输出: a #<tr> aava #<tr> abb

        //3. 占有型（Possessive）java不存在 不能回溯

    }


}
