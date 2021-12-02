package com.it.函数式.Consumer;

import java.util.function.Consumer;

/**
 * to do
 *Consumer 接口表示执行在单个参数上的操作。
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());

        greeter.accept(new Person( "Skywalker"));


    }
}
