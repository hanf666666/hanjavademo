package com.mt.entity.����ʽ.Consumer;

import java.util.function.Consumer;

/**
 * to do
 *Consumer �ӿڱ�ʾִ���ڵ��������ϵĲ�����
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());

        greeter.accept(new Person( "Skywalker"));


    }
}
