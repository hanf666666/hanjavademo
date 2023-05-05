package com.newsfeatures.Optional.demo02;

import java.util.Optional;

/**
 * to do
 *  flatMap������ɱ���ָ��,
 *  �����������
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

