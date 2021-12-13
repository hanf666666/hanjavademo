package com.it.test08_匿名内部类讲解;

public class Test02_Person {
    public static void main(String[] args) {
        //需求: 调用Person#eat()
        /*
            方式一: 普通实现.
                1. 创建一个类, 继承Person.
                2. 重写eat().
                3. 创建子类对象, 调用eat();
         */
        //3
        Person person = new Student();
        person.eat();
        System.out.println("*********");

        //方式二: 匿名对象实现
        //new Student();    这是一个继承了Person类的子类(Student)的匿名对象.
        new Student().eat();
        System.out.println("*********");

        /*
            方式三: 匿名内部类实现
                格式:
                    new 类名或者接口名(){
                        //这里重写所有的抽象方法
                    };
               本质:
                    专业版: 就是一个继承了类或者实现了接口的匿名的子类对象.
                    大白话: 就是接口或者类的 匿名的子类对象.
         */
        new Person() {
            @Override
            public void eat() {
                System.out.println("我是匿名内部类的方式实现了,  创建子类对象, 吃 牛肉汤");
            }
        }.eat();
    }
}
