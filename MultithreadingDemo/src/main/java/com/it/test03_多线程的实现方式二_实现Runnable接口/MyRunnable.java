package com.it.test03_���̵߳�ʵ�ַ�ʽ��_ʵ��Runnable�ӿ�;

//A: ������(MyRunnable��), ʵ��Runnable�ӿ�
public class MyRunnable implements  Runnable {

    //B: ��д�ӿ��е�run()����.
    @Override
    public void run() {
        //C: ��Ҫִ�еĴ���ŵ�run()������.
        for (int i = 0; i < 200; i++) {
            System.out.println("ʵ��Runnable�ӿڵķ�ʽʵ�ֶ��߳�..." + i);
        }
    }
}
