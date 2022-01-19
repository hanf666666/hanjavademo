package com.mt.entity.FunctionalInterface1.FunctionalInterface;

import com.mt.entity.FunctionalInterface1.Converter;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class maintest1 {
    public static void main(String[] args) {
        //函数接口的简写 (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from)+1;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 124
    }
}
