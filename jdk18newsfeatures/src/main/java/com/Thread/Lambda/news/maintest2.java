package com.Thread.Lambda.news;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * to do
 *ֻ��Ҫ����̬���� Collections.sort ����һ��List�����Լ�һ���Ƚ�������ָ��˳�����С�

 * @author Hj
 * @date 2021/12/1
 */
public class maintest2 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("2peter", "1anna", "3mike", "4xenia");
        System.out.println(stringList);
        //�ӿ�ʵ�ּ�д==>�����Ĳ���->����ֵ
        Collections.sort(stringList, (String a, String b) -> b.compareTo(a));
        Collections.sort(stringList, ( a, b) -> b.compareTo(a));
        System.out.println(stringList);



    }
}
