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
        Optional<String> optional1 = Optional.ofNullable("abcd");  //非空实例
        Optional<String> optional2 = Optional.ofNullable(null);  //空实例

        System.out.println(optional1.filter(a -> a.startsWith("ab")).get()=="abcd");
        //非空实例场景
        Assert.assertEquals(optional1.filter(a -> a.startsWith("ab")).get(), "abcdjj");      //表达式结果为true，保留当前实例
        Assert.assertEquals(optional1.filter(a -> a.startsWith("AB")), Optional.empty());   //表达式结果为fasle，返回空实例

//        //空实例场景，直接返回空对象
        Assert.assertEquals(optional2.filter((a) -> (1 == 1)), Optional.empty());

    }
}
