package com.print.FunctionalInterface1;

/**
 * to do
 *  ע��Ҳ��FunctionalInterface
 * @author Hj
 * @date 2021/12/1
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
//    T convert2(F from);
}
