package com.newsfeatures.º¯ÊýÊ½.Function1;

import java.util.function.Function;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class  maintest2{
    public static void main(String[] args) {
        Function<Integer, Integer> toIntegerFunction = (a)->a+1;
        Function<Integer, Integer> backToStringFunction = toIntegerFunction.andThen((a)->a*a);
        System.out.println(backToStringFunction.apply(1));//1+1=2   2*2=4
        System.out.println(backToStringFunction.apply(2));//2+1=3   3*3=9


    }
}
