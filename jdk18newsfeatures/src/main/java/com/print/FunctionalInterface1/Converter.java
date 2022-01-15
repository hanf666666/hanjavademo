package com.print.FunctionalInterface1;

/**
 * to do
 *  ×¢ÊÍÒ²ÐÐFunctionalInterface
 * @author Hj
 * @date 2021/12/1
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
//    T convert2(F from);
}
