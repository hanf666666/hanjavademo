package com.it.DesignPattern.������.ԭ��ģʽ.ǳ��¡;

import com.it.DesignPattern.������.ԭ��ģʽ.���¡.ʵ��serialrizable.EntityFather;
import com.it.DesignPattern.������.ԭ��ģʽ.���¡.ʵ��serialrizable.EntitySon;;

public class maindemo {


    public static void main(String[] args) {
        com.it.DesignPattern.������.ԭ��ģʽ.���¡.ʵ��serialrizable.EntityFather entity01 = new com.it.DesignPattern.������.ԭ��ģʽ.���¡.ʵ��serialrizable.EntityFather();
        entity01.setName("daming");
        com.it.DesignPattern.������.ԭ��ģʽ.���¡.ʵ��serialrizable.EntitySon entitySon = new EntitySon();
        entitySon.setName("xiaoming");
        entity01.setSon(entitySon);
        System.out.println(entity01);

        com.it.DesignPattern.������.ԭ��ģʽ.���¡.ʵ��serialrizable.EntityFather entity02 = (EntityFather) entity01.clone();
        entitySon.setName("huangxiaoming");
        System.out.println(entity01+"==="+entity02);

    }
}
