package com.base01.test08_匿名内部类讲解.anonymousclass;

public class Test01 {

    public static void main(String[] args) {
        //匿名内部类是非静态内部类的一种，它可以访问外部类的成员
        new PeopleInterface() {

            @Override
            public void say() {
                System.out.println("我是继承PeopleInterface的say()方法");
            }

        };
    }
}
