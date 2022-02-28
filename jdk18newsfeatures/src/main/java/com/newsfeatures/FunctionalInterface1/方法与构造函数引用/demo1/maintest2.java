package com.newsfeatures.FunctionalInterface1.方法与构造函数引用.demo1;

import com.newsfeatures.FunctionalInterface1.Converter;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class maintest2 {
    public static void main(String[] args) {
        //函数接口的简写 (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }
}
