package com.base01.test07_���߳�ģ����Ʊ_ʵ��Runnable�ӿڰ�;

public class MyRunnable implements  Runnable{
    //1. �������,  ��¼Ʊ��.
    private int tickets = 100;       //static���Բ����Բ�д? ����


    //2. ��run��ģ����Ʊ.
    @Override
    public void run() {
        while(true) {
            //������ֽ����ļ�����,   �����this��ʵ����(mr)
           synchronized (this) {
               if (tickets < 1) {
                   break;
               }
               //Ϊ����Ч��������.
               try {
                   Thread.sleep(50);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               //��������Ʊ���߼�
               System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets-- + "��Ʊ");
           }
        }
    }
}
