package com.CAS.reentranlock;

import java.util.concurrent.locks.ReentrantLock;

public class demo01 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            moneychange();
            reentrantLock.unlock();

        },"thread1");


        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
            moneychange();
            reentrantLock.unlock();

        },"thread2");
        thread1.start();
        thread2.start();


    }
    public static void moneychange() {

        System.out.println(Thread.currentThread().getName()+"=��ʼȡǮ===>");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"<=ȡǮ����===");
    }
}
