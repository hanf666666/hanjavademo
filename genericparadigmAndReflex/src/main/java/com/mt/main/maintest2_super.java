package com.mt.main;

import com.Thread.Lev2.Fruit;
import com.Thread.Lev3.Apple;
import com.Thread.container.Plate;

/**
 * to do
 *ʹ���½�<? super Fruit>��ʹ��������ȡ������get( )��������ʧЧ��ֻ�ܴ�ŵ�Object�����set( )����������
 * @author Hj
 * @date 2021/12/2
 */
public class maintest2_super {
    public static void main(String[] args) {
        Plate<? super Fruit> plate=new Plate<Fruit>(new Fruit());

//����Ԫ������
        plate.set(new Fruit());
        plate.set(new Apple());

//��ȡ�����Ķ���ֻ�ܴ����Object���
//        Apple newFruit3=plate.get();    //Error
//        Fruit newFruit1=plate.get();    //Error
        Object newFruit2=plate.get();

    }
}
