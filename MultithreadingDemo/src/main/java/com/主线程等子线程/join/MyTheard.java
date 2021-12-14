package com.主线程等子线程.join;


public class MyTheard extends Thread {

    public MyTheard() {
    }


    @Override
    public void run() {
        synchronized (MyTheard.class) {
            super.run();
            StaticValue.count += 1;
            System.out.println(11111);
        }
    }
}
