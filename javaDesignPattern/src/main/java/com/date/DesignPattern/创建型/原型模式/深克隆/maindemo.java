package com.date.DesignPattern.创建型.原型模式.深克隆;

import com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable.EntityFather;
import com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable.EntitySon;;

public class maindemo {


    public static void main(String[] args) {
        com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable.EntityFather entity01 = new com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable.EntityFather();
        entity01.setName("daming");
        com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable.EntitySon entitySon = new EntitySon();
        entitySon.setName("xiaoming");
        entity01.setSon(entitySon);
        System.out.println(entity01);

        com.date.DesignPattern.创建型.原型模式.深克隆.实现serialrizable.EntityFather entity02 = (EntityFather) entity01.clone();
        entitySon.setName("huangxiaoming");
        System.out.println(entity01+"==="+entity02);

    }
}
