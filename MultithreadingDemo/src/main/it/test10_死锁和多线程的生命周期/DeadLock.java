package com.date.test10_�����Ͷ��̵߳���������;

/**
 * ����������ʾ
 */
public class DeadLock {
    //������
    private static final String LOCKA = "��A";
    private static final String LOCKB = "��B";

    public static void main(String[] args) {
        /*
            ����˼��:
                1. �����߳�, ������.
                2. һ���߳���A,��B,
                    ��һ���߳���B, ��A.
                3. Ϊ����Ч��������, ��while(true)�Ľ�.
         */
        //�߳�1,  һ���߳���A,��B,
        new Thread(){
            @Override
            public void run() {
                while(true) {

                    //��A
                    synchronized (LOCKA) {
                        System.out.println("1��ȡ��" + LOCKA + ", �ȴ�" + LOCKB);
                        //��B
                        synchronized (LOCKB) {
                            System.out.println("1��ȡ��" + LOCKB + ", �ɹ�������С����");
                        }
                    }
                }
            }
        }.start();

        //�߳�2,  һ���߳���B,��A,
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    //��B
                    synchronized (LOCKB) {
                        System.out.println("2��ȡ��" + LOCKB + ", �ȴ�" + LOCKA);
                        //��A
                        synchronized (LOCKA) {
                            System.out.println("2��ȡ��" + LOCKA + ", �ɹ�������С����");
                        }
                    }
                }
            }
        }.start();

    }
}
