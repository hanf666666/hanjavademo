package com.newsfeatures.�̰߳�ȫ.demo02;

public class Count {

    static int  count=0;

    public /*static synchronized*/ void add(String str,long ���̺�){

        if("a".equals(str)){
            count=100;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count+", a   "+���̺�);
        }else{
            count=200;
            System.out.println(count+",  b "+���̺�);
        }

    }
}
