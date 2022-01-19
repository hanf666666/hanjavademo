package com.mt.entity.º¯ÊýÊ½.Predicate1;

import java.util.Objects;
import java.util.function.Predicate;


/**
 * to do
 *  ¶ÏÑÔ
 * @author Hj
 * @date 2021/12/1
 */
public class maintest1 {
    public static void main(String[] args) {

        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("foo"));// true
        System.out.println(predicate.negate().test("foo"));     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

       Predicate<String> isEmptyPredicate = String::isEmpty;
        System.out.println(isEmptyPredicate.test("foo"));// true
        System.out.println(isEmptyPredicate.negate().test("foo"));     // false

        Predicate<String> isNotEmpty = isEmptyPredicate.negate();

    }
}
