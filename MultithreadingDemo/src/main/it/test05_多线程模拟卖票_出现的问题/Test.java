package com.it.test05_���߳�ģ����Ʊ_���ֵ�����;

/**
 * ������, ģ����Ʊ
 */
public class Test {
    public static void main(String[] args) {
        //3. �ڲ�������, ����4���߳�, ��Ʊ.
        /*MyThread mt1 = new MyThread();
        mt1.setName("����1");*/

        MyThread mt1 = new MyThread("����1");
        MyThread mt2 = new MyThread("����2");
        MyThread mt3 = new MyThread("����3");
        MyThread mt4 = new MyThread("����4");

        //�����߳�
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
    }
}
