package com.mt.entity.���̵߳����߳�.LockSupport08;

import java.util.concurrent.locks.LockSupport;

public class demo01 {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        Thread t = new Thread(() -> {
            //���߳̽����ַ������Ӳ���
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            LockSupport.unpark(mainThread);
        });
//��ʼ��ʱ
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        LockSupport.park();// �൱����ͣ���߳�
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));




    }
}
