package com.it.mt.main;

import com.it.container.Plate;
import com.it.Lev2.Fruit;
import com.it.Lev3.Apple;

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
