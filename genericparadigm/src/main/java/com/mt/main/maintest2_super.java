package com.mt.main;

import com.Thread.Lev2.Fruit;
import com.Thread.Lev3.Apple;
import com.Thread.container.Plate;

/**
 * to do
 *使用下界<? super Fruit>会使从盘子里取东西的get( )方法部分失效，只能存放到Object对象里。set( )方法正常。
 * @author Hj
 * @date 2021/12/2
 */
public class maintest2_super {
    public static void main(String[] args) {
        Plate<? super Fruit> plate=new Plate<Fruit>(new Fruit());

//存入元素正常
        plate.set(new Fruit());
        plate.set(new Apple());

//读取出来的东西只能存放在Object类里。
//        Apple newFruit3=plate.get();    //Error
//        Fruit newFruit1=plate.get();    //Error
        Object newFruit2=plate.get();

    }
}
