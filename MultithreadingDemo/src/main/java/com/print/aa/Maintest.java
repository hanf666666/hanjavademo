package com.print.aa;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/6
 */
public class Maintest {
    public static void main(String[] args) {
        int a=1;
        final Thread thread = new Thread() {
           int a=2;
            @Override
            public void run() {
                int a=3;
                for (int i = 0; i < 10000000; i++) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(a);
                    System.out.println(this.a);
                }


            }
        };
        thread.start();
        System.out.println("=================主线程结束");



    }
}
