package com.date.test08_�����ڲ��ི��;

public class Test04_ʹ�ó�����ʾ {
    public static void main(String[] args) {
        //����: ����method().
        //��ʽһ: �����������, Ȼ�����.
        Student student = new Student();
        method(student);

        System.out.println("***********");

        //��ʽ��: ���������ڲ���ʵ��.
        //method(Person���͵��������);
        method(new Person() {
            @Override
            public void eat() {
                System.out.println("���������ڲ�����ʽ��, Person���������");
            }
        });

    }

    public static void method(Person p) {
        p.eat();
    }
}

