package com.base01.test09_ͬ����������������ʾ;

public class Demo {
    public static synchronized void method1() {
        //�����ͬ������
        System.out.print("i");
        System.out.print("t");
        System.out.print("c");
        System.out.print("a");
        System.out.print("s");
        System.out.print("t");
        System.out.print("\r\n");
    }

    public static void method2() {
        //�����ͬ�������
        synchronized(Demo.class) {
            System.out.print("��");
            System.out.print("��");
            System.out.print("��");
            System.out.print("��");
            System.out.print("Ա");
            System.out.print("\r\n");
        }
    }
}
