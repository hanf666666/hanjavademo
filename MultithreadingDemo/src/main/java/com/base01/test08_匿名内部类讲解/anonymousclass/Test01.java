package com.base01.test08_�����ڲ��ི��.anonymousclass;

public class Test01 {

    public static void main(String[] args) {
        //�����ڲ����ǷǾ�̬�ڲ����һ�֣������Է����ⲿ��ĳ�Ա
        new PeopleInterface() {

            @Override
            public void say() {
                System.out.println("���Ǽ̳�PeopleInterface��say()����");
            }

        };
    }
}
