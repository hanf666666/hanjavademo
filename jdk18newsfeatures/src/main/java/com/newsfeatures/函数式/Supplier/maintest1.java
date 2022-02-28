package com.newsfeatures.函数式.Supplier;

import java.util.function.Supplier;

/**
 * to do
 * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


    }
}
