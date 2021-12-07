package com.it.aa;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/6
 */
public class Maintest {
    public static void main(String[] args) {
        int a=1;
        final Runnable runnable = new Runnable() {
           int a=2;
            @Override
            public void run() {
                int a=3;
                System.out.println(a);
                System.out.println(this.a);

            }
        };
        runnable.run();


    }
}
