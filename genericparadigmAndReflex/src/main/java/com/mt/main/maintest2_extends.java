package com.mt.main;

import com.Thread.Lev2.Fruit;
import com.Thread.Lev3.Apple;
import com.Thread.container.Plate;

/**
 * to do
 *�Ͻ�<? extends T>��������棬ֻ������ȡ
 * @author Hj
 * @date 2021/12/2
 */
public class maintest2_extends {
    public static void main(String[] args) {
        Plate<? extends Fruit> plate=new Plate<Apple>(new Apple());
        //���ܴ����κ�Ԫ��
//        plate.set(new Fruit());    //Error
//        plate.set(new Apple());    //Error
        //��ȡ�����Ķ���ֻ�ܴ����Fruit�����Ļ����
        Fruit newFruit1 = plate.get();
        Object newFruit2 = plate.get();
//        Apple newFruit3 = plate.get();    //Error

    }
}
