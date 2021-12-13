package com.CAS.demo;


import java.util.concurrent.locks.ReentrantLock;

public class MyTheard extends Thread {

    public MyTheard() {
    }


    @Override
    public void run() {
        synchronized (MyTheard.class) {
            super.run();
            StaticValue.reentrantLock.lock();
            System.out.println(StaticValue.reentrantLock);
            StaticValue.count += 1;
            StaticValue.reentrantLock.unlock();
        }
    }
}
