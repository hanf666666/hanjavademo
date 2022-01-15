package com.print.���̵߳����߳�.synchronized2;

/**
 * ��̫���� Object����ס
 */
public class demo {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t Over");
            synchronized (lock) {
                System.out.println("����ô������");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();//���̻߳���
            }
        });
        //��ʱ
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        //�������߳�
        t.start();
        try {
            synchronized (lock) {
                System.out.println("����======��");
                lock.wait();//���̵߳ȴ�
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));


    }
}
