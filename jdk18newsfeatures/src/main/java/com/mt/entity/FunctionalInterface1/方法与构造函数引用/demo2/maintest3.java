package com.mt.entity.FunctionalInterface1.�����빹�캯������.demo2;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class maintest3 {
    public static void main(String[] args) {
        //  PersonFactory<Person> personFactory = Person::new;===>�ӿڵļ�д
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }
}
