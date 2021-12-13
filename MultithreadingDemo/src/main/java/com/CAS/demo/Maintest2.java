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
        System.out.println(StaticValue.count);





    }
}
