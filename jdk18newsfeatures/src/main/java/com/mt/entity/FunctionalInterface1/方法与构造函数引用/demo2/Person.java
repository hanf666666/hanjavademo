package com.mt.entity.FunctionalInterface1.�����빹�캯������.demo2;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
