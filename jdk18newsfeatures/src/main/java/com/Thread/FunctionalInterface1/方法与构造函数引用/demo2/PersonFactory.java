package com.Thread.FunctionalInterface1.�����빹�캯������.demo2;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
@FunctionalInterface
//extends Person��ʡ��
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
