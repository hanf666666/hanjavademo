package com.date.test03_���̵߳�ʵ�ַ�ʽ��_ʵ��Runnable�ӿ�;

public class Test {
    public static void main(String[] args) {
        //D: �����߳�.
        //����Runnable�ӿڵ��������.
        MyRunnable mr = new MyRunnable();

        //������Ϊ��������Thread��Ĺ���, �����̶߳���.
        //public Thread(Runnable target)
        Thread th = new Thread(mr);

        //E: �����߳�
        th.start();


        for (int i = 0; i < 200; i++) {
            System.out.println("main..." + i);
        }
    }
}
