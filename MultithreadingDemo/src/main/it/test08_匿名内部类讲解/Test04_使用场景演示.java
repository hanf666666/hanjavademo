package com.date.test08_匿名内部类讲解;

public class Test04_使用场景演示 {
    public static void main(String[] args) {
        //需求: 调用method().
        //方式一: 创建子类对象, 然后调用.
        Student student = new Student();
        method(student);

        System.out.println("***********");

        //方式二: 采用匿名内部类实现.
        //method(Person类型的子类对象);
        method(new Person() {
            @Override
            public void eat() {
                System.out.println("我是匿名内部类形式的, Person的子类对象");
            }
        });

    }

    public static void method(Person p) {
        p.eat();
    }
}

