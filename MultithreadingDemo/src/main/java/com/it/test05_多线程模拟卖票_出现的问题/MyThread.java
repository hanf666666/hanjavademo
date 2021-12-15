package com.it.test05_���߳�ģ����Ʊ_���ֵ�����;

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

            //D: Ϊ���÷Ƿ�ֵ�����������, ���Ǽ���: �����߳�.
            try {     //�߳�1, �߳�2, �߳�3, �߳�4
                Thread.sleep(50);  //�ص�, ����˯, ������.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //C: �ߵ�����, ˵����Ʊ, ������
            //System.out.println(this.getName() +  "���ڳ��۵�" + tickets-- + "��Ʊ");
            System.out.println(getName() +  "���ڳ��۵�" + tickets-- + "��Ʊ");

            /*
                ���ָ���:  �ؼ�����: ifУ��, sleep()����.
                    �߳�1��ִ��: �������1��Ʊ, ��ӡ��Ϻ�, tickets��ֵ���� 0
                    �߳�2��ִ��: �������0��Ʊ, ��ӡ��Ϻ�, tickets��ֵ���� -1
                    �߳�3��ִ��: �������-1��Ʊ, ��ӡ��Ϻ�, tickets��ֵ���� -2
                    �߳�4��ִ��: �������-2��Ʊ, ��ӡ��Ϻ�, tickets��ֵ���� -3
             */

            /*
                �ظ�ֵ: �ؼ���: tickets--
                    tickets-- �൱��  tickets = tickets - 1;
                    A: ��ֵ. ��ȡtickets��ֵ.
                    B: ��ֵ. ��tickets��ֵ-1
                    C: ��ֵ. ��tickets-1�����ֵ���¸�ֵ��tickets.

                    ��û�����ü�ִ��C��֮��, ������߳�������Դ��.

             */
        }
    }
}
