package com.mt.entity.����ʽ.Function1;

import java.util.function.Function;

/**
 * to do
 * �ַ�תint
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        Function<String, Integer> toIntegerFunction = Integer::valueOf;
        Function<String, String> backToStringFunction = toIntegerFunction.andThen(String::valueOf);

        System.out.println(backToStringFunction.apply("123"));  // "123"


    }
}
