package com.Thread.FunctionalInterface1.方法与构造函数引用.demo2;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
@FunctionalInterface
//extends Person可省略
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
