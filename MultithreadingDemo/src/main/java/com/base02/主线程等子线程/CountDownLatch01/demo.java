package com.base02.���̵߳����߳�.CountDownLatch01;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class demo {
    public static void main(String[] args) {
        int threadNumber = 4;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);//����Ϊ�̸߳���

        for (int i = 1; i <10 ; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(finalI *1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();//�˷�����CountDownLatch���߳���-1
            });
            t.start();
        }

        long start = System.currentTimeMillis();
        System.out.println("start = " + start);

       //�߳����������countDownLatch����
        try {
            //��Ҫ�����쳣���������߳���Ϊ0ʱ����Ż��������
            countDownLatch.await();
            System.out.println("=====================");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));

    }
}
