package com.newsfeatures.����ʽ.Function1;

import java.util.function.Function;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest3 {
    public static void main(String[] args) {

        //��д   (a)->{}����new�˸����ö���
//        Function<Integer, Integer> toIntegerFunction = (a)->{
//
//            System.out.println(a+"=================>");
//            return a;
//        };

        //   jdk Functionԭʼд��д
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
