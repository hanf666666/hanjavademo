package com.date.test02_ʵ�ַ�ʽһ_�̳�Thread��;

/**
 * ������, ����MyThread����.
 */
public class Test {
    /*
        main�����ǳ���������,
        ���д����ִ�ж��Ǵ����￪ʼ��.
     */
    public static void main(String[] args) {
       // D: �����̶߳���.
        MyThread mt = new MyThread();

       // E: �����߳�.
        /*
            Сϸ��:
                1. �����̱߳������start()����, �÷������Զ�����run().
                2. ͬһ�̲߳����ظ�����, ���߻ᱨ:IllegalThreadStateException(�Ƿ����߳�״̬�쳣)
         */
        //mt.run();   //�����������run(), ֻ����ͨ�ķ�������.
        mt.start();
       // mt.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("main..........." + i);
        }
    }
}
