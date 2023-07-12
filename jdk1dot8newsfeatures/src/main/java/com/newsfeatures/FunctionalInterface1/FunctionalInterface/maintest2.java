package com.newsfeatures.FunctionalInterface1.FunctionalInterface;

import com.newsfeatures.FunctionalInterface1.CallbackFunction;
import com.newsfeatures.FunctionalInterface1.Converter;
import org.junit.Test;

import java.util.HashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/1
 */
public  class maintest2 {
    @Test
    public  void demo() {
        HashMap<String, CallbackFunction> stringConverterHashMap = new HashMap<>();
        stringConverterHashMap.put("aaa", this::getValue222222);

    }

    private void getValue222222(Object o) {
        System.out.println("========================>");
    }



}
