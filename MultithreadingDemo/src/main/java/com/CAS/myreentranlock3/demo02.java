package com.CAS.myreentranlock3;



public class demo02 {
    public static void main(String[] args) {
        MyReentranLock reentrantLock = new MyReentranLock();
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

        System.out.println(Thread.currentThread().getName()+"=开始取钱===>");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"<=取钱结束===");
    }
}
