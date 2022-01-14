package com.Thread.Optional.demo03;

import java.util.Optional;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class Test {

    public static void main(String[] args) {
        People people = new People();
        Optional<People> p = Optional.ofNullable(people);
        String name = p.map(People::getCar)
                .map(Car::getInsurence)
                .map(Insurence::getName)
                .orElseGet(null);
        System.out.println(name);
    }

}

