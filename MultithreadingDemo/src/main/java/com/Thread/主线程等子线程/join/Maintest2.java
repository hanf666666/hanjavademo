package com.Thread.���̵߳����߳�.join;

import java.util.ArrayList;

public class Maintest2 {
    public static void main(String[] args) {
        ArrayList<MyTheard> myTheardArrayList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            MyTheard myTheard = new MyTheard();
            myTheard.start();
        }

        myTheardArrayList.forEach((myTheard)->{
            try {
                myTheard.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        System.out.println(StaticValue.count);





    }
}
