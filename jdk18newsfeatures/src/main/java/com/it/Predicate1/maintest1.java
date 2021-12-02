package com.it.Predicate1;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class maintest1 {
    public static void main(String[] args) {

        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

    }
}
