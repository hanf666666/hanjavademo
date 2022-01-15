package com.print.���̵߳����߳�.BlockingQueue02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class demo01 {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1);//�����Ͷ��У�����Ϊ1
        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            try {
                queue.put("OK");//�ڶ����м�������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        try {
            queue.take();//���߳��ڶ����л�ȡ���ݣ�take()�������������У�ps���в��������ķ���
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));




    }
}
