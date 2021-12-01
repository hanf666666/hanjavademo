package com.it.interface1;

/**
 * to do
 *一个非抽象的方法实现，只需要使用 default关键字即
 * @author Hj
 * @date 2021/12/1
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
