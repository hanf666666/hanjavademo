package com.it.test07_���߳�ģ����Ʊ_ʵ��Runnable�ӿڰ�;

public class Test {
    public static void main(String[] args) {
        //3. �ڲ������д�������, ����.
        //����Runnable�ӿڵ��������
        MyRunnable mr = new MyRunnable();
        //������Ϊ��������Thread��Ĺ��췽��, �����̶߳���.
        //public Thread(Runnable target);
        //public Thread(Runnable target, String name);
        Thread th1 = new Thread(mr, "����1");
        Thread th2 = new Thread(mr, "����2");
        Thread th3 = new Thread(mr, "����3");
        Thread th4 = new Thread(mr, "����4");

        //�����߳�
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
