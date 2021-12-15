package com.it.test04_���߳�ģ����Ʊ_�����汾;

/**
 * �Զ�����߳���, ģ����Ʊ
 */
public class MyThread extends Thread{

    /*
        ˼·:
            1. �������, ��¼�����100��Ʊ.
            2. ��run()������ʵ��, ��Ʊ�Ķ���.
            3. �ڲ�������, ����4���߳�, ��Ʊ.
     */
    //1
   private static int tickets = 100;          //����

    //���췽��
    //alt + insert


    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    //2
    @Override
    public void run() {
        /*
            ��Ʊ�Ķ���:
                A: ��Ϊ��֪��ʲôʱ������, ������while(true).
                B: ��һ���Ƿ�ֵУ��, ���ûƱ��, �Ͳ�����.
                C: ��������Ʊ�߼�.
         */
        //A
        while(true) {
            if (tickets < 1) {
                //B: ��������, ˵��ûƱ��
                break;
            }

            //C: �ߵ�����, ˵����Ʊ, ������
            //System.out.println(this.getName() +  "���ڳ��۵�" + tickets-- + "��Ʊ");
            System.out.println(getName() +  "���ڳ��۵�" + tickets-- + "��Ʊ");
        }
    }
}
