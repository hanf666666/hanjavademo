package com.mt.main;

import com.newsfeatures.container.Plate;
import com.newsfeatures.Lev2.Fruit;
import com.newsfeatures.Lev3.Apple;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
//        final Apple apple = new Apple();
        Plate<? extends Fruit> p=new Plate<Apple>(new Apple());



    }
}
