package com.it.test08_�����ڲ��ི��;

public class Test02_Person {
    public static void main(String[] args) {
        //����: ����Person#eat()
        /*
            ��ʽһ: ��ͨʵ��.
                1. ����һ����, �̳�Person.
                2. ��дeat().
                3. �����������, ����eat();
         */
        //3
        Person person = new Student();
        person.eat();
        System.out.println("*********");

        //��ʽ��: ��������ʵ��
        //new Student();    ����һ���̳���Person�������(Student)����������.
        new Student().eat();
        System.out.println("*********");

        /*
            ��ʽ��: �����ڲ���ʵ��
                ��ʽ:
                    new �������߽ӿ���(){
                        //������д���еĳ��󷽷�
                    };
               ����:
                    רҵ��: ����һ���̳��������ʵ���˽ӿڵ��������������.
                    ��׻�: ���ǽӿڻ������ �������������.
         */
        new Person() {
            @Override
            public void eat() {
                System.out.println("���������ڲ���ķ�ʽʵ����,  �����������, �� ţ����");
            }
        }.eat();
    }
}
