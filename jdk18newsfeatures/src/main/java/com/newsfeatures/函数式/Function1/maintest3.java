package com.newsfeatures.函数式.Function1;

import java.util.function.Function;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest3 {
    public static void main(String[] args) {

        //简写   (a)->{}就是new了个引用对象
//        Function<Integer, Integer> toIntegerFunction = (a)->{
//
//            System.out.println(a+"=================>");
//            return a;
//        };

        //   jdk Function原始写法写
        Function<Integer, Integer> toIntegerFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer a) {
                System.out.println(a + "=================>");

                return a;
            }
        };


        Integer apply = toIntegerFunction.apply(2);
        System.out.println("@@@@@@@" + apply);


    }
}
