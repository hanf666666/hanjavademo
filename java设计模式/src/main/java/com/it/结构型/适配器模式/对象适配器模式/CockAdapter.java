package com.it.结构型.适配器模式.对象适配器模式;

public class CockAdapter implements Duck {

    Cock cock;
    // 构造方法中需要一个鸡的实例，此类就是将这只鸡适配成鸭来用
    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    @Override
    public void quack() {
        cock.gobble();

    }

    @Override
    public void fly() {
        cock.fly();

    }
}
