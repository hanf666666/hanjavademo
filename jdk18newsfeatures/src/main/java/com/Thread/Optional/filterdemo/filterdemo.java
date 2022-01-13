package com.Thread.Optional.filterdemo;


import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class filterdemo {
    @Test
    public  void test() {
        Optional<String> optional1 = Optional.ofNullable("abcd");  //�ǿ�ʵ��
        Optional<String> optional2 = Optional.ofNullable(null);  //��ʵ��

        System.out.println(optional1.filter(a -> a.startsWith("ab")).get()=="abcd");
        //�ǿ�ʵ������
        Assert.assertEquals(optional1.filter(a -> a.startsWith("ab")).get(), "abcdjj");      //���ʽ���Ϊtrue��������ǰʵ��
        Assert.assertEquals(optional1.filter(a -> a.startsWith("AB")), Optional.empty());   //���ʽ���Ϊfasle�����ؿ�ʵ��

//        //��ʵ��������ֱ�ӷ��ؿն���
        Assert.assertEquals(optional2.filter((a) -> (1 == 1)), Optional.empty());

    }
}
