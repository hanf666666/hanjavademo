package com.mt.entity.FunctionalInterface1.方法与构造函数引用.demo2;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public class maintest3 {
    public static void main(String[] args) {
        //  PersonFactory<Person> personFactory = Person::new;===>接口的简写
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }
}
