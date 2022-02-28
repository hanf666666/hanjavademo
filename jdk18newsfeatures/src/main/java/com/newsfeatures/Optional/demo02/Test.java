package com.newsfeatures.Optional.demo02;

import java.util.Optional;

/**
 * to do
 *  flatMap这个依旧报空指真,
 *  这个案例不好
 * @author Hj
 * @date 2022/1/13
 */
public class Test {

    public static void main(String[] args) {
        People people = null;
        Optional<People> p = Optional.ofNullable(people);
//        p.map(t->t.getCar());
        String name = p.flatMap(People::getCar)
                .flatMap(Car::getInsurence)
                .map(Insurence::getName)
                .orElseGet(()->"string");
        System.out.println(name);
    }

}

