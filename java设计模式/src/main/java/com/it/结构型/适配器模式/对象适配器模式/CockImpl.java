package com.it.结构型.适配器模式.对象适配器模式;

public class CockImpl implements Cock {

        public void gobble() {
            System.out.println("咕咕叫");
        }
        public void fly() {
            System.out.println("鸡也会飞哦");
        }
}
