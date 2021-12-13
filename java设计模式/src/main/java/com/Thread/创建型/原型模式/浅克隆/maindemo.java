package com.Thread.������.ԭ��ģʽ.ǳ��¡;

public class maindemo {


    public static void main(String[] args) {
        EntityFather entity01 = new EntityFather();
        entity01.setName("daming");
        EntitySon entitySon = new EntitySon();
        entitySon.setName("xiaoming");
        entity01.setSon(entitySon);
        System.out.println(entity01);

        EntityFather entity02 = (EntityFather) entity01.clone();
        entitySon.setName("huangxiaoming");
        System.out.println(entity01+"==="+entity02);

    }
}
