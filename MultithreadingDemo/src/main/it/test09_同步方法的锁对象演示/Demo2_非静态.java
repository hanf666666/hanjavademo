package com.date.test09_ͬ����������������ʾ;

public class Demo2_�Ǿ�̬ {
    public synchronized void method1() {
        //�����ͬ������
        System.out.print("i");
        System.out.print("t");
        System.out.print("c");
        System.out.print("a");
        System.out.print("s");
        System.out.print("t");
        System.out.print("\r\n");
    }

    public void method2() {
        //�����ͬ�������
        synchronized(this) {
            System.out.print("��");
            System.out.print("��");
            System.out.print("��");
            System.out.print("��");
            System.out.print("Ա");
            System.out.print("\r\n");
        }
    }
}
