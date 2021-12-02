package com.it.main;

import com.it.Lev2.Fruit;
import com.it.Lev3.Apple;
import com.it.container.Plate;

/**
 * to do
 *上界<? extends T>不能往里存，只能往外取
 * @author Hj
 * @date 2021/12/2
 */
public class maintest2_extends {
    public static void main(String[] args) {
        Plate<? extends Fruit> plate=new Plate<Apple>(new Apple());
        //不能存入任何元素
//        plate.set(new Fruit());    //Error
//        plate.set(new Apple());    //Error
        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1 = plate.get();
        Object newFruit2 = plate.get();
//        Apple newFruit3 = plate.get();    //Error

    }
}
