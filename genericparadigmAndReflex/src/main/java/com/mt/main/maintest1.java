package com.mt.main;

import com.print.container.Plate;
import com.print.Lev2.Fruit;
import com.print.Lev3.Apple;

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
