package com.it.test02_ʵ�ַ�ʽһ_�̳�Thread��;

/**
 * ������Զ�����߳���: MyThread
 */

//A: ����һ����(MyThread), �̳�Thread��.
public class MyThread extends Thread{
    //B: ��дThread#run().

    @Override
    public void run() {
        //C: ��Ҫִ�еĴ�����뵽run()��.
        for (int i = 0; i < 200; i++) {
            System.out.println("run...." + i);
        }
    }
}
