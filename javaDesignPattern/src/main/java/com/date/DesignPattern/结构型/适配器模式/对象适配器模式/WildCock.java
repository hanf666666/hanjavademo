package com.date.DesignPattern.结构型.适配器模式.对象适配器模式;

/**
 * to do
 *
 * @author Hj
 * @date 2022/11/25
 */
public class WildCock implements Cock {
    public void gobble() {
        System.out.println("咕咕叫");
    }
    public void fly() {
        System.out.println("鸡也会飞哦");
    }
}