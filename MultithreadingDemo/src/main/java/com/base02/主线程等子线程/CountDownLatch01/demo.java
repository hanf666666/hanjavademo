package com.base02.���̵߳����߳�.CountDownLatch01;

import java.util.concurrent.CountDownLatch;

public class demo {
    public static void main(String[] args) {
        int threadNumber = 1;
        final CountDownLatch cdl = new CountDownLatch(threadNumber);//����Ϊ�̸߳���

        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            cdl.countDown();//�˷�����CountDownLatch���߳���-1
        });

        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
//�߳����������countDownLatch����
        try {
            cdl.await();//��Ҫ�����쳣���������߳���Ϊ0ʱ����Ż��������
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));

    }
}
