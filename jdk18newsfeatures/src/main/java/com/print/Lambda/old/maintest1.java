package com.print.Lambda.old;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * to do
 *ֻ��Ҫ����̬���� Collections.sort ����һ��List�����Լ�һ���Ƚ�������ָ��˳�����С�
 * ͨ���������Ǵ���һ��
 * �����ıȽ�������Ȼ���䴫�ݸ�sort������
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
