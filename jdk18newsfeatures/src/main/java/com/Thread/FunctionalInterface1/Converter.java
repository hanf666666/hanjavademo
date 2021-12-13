package com.Thread.FunctionalInterface1;

/**
 * to do
 *  注释也行FunctionalInterface
 * @author Hj
 * @date 2021/12/1
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
//    T convert2(F from);
}