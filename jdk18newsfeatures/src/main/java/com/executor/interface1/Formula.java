package com.executor.interface1;

/**
 * to do
 *һ���ǳ���ķ���ʵ�֣�ֻ��Ҫʹ�� default�ؼ��ּ�
 * @author Hj
 * @date 2021/12/1
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
