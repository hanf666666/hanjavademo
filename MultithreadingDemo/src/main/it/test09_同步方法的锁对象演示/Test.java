package com.date.test09_ͬ����������������ʾ;

public class Test {
    public static void main(String[] args) {
        /*
        	����˼·:
                1. ���������߳�, һ������method1, ��һ������method2().
                2. �����ӡ���û����, ��˵������ʹ�õ���ͬһ����.
                3. Ϊ����Ч��������, ��while(true)�Ľ�.
         */
        //�߳�1, ����method1()
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    Demo.method1();
                }
            }
        }.start();


        //�߳�2, ����method2().
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    Demo.method2();
                }
            }
        }.start();

        //��ʽһ: �̳�Thread��.
        //new Thread(){
        //  ��дrun();
        // }.start();

        //��ʽ��: ʵ��Runnable�ӿ�.
        /*new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();*/


    }
}
