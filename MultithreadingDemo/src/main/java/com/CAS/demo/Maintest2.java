package com.CAS.demo;

public class Maintest2 {
    public static void main(String[] args) {
        System.out.println(StaticValue.reentrantLock);
        System.out.println(StaticValue.reentrantLock);
        System.out.println(StaticValue.reentrantLock==StaticValue.reentrantLock);

        for (int i = 0; i < 1000; i++) {
            MyTheard myTheard = new MyTheard();
            myTheard.start();

        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(StaticValue.count);





    }
}
