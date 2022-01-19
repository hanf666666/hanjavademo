package com.mt.entity.�̰߳�ȫ;

import org.junit.Test;

public class DirtyRead {
    private String weibo_name = "���»�";
    private String weibo_sex = "��";

    public  void setValue(String weibo_name, String weibo_sex) {
        synchronized(this){
        this.weibo_name = weibo_name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.weibo_sex = weibo_sex;
        System.out.println("�������÷���    setValue---------weibo_name :" + weibo_name +
                "-- weibo_sex : " + weibo_sex+"�߳���:"+Thread.currentThread().getName());

    }
    }


    public void getValue() {
        System.out.println("���ǻ�ȡ����   getValue---------weibo_name :" +
                weibo_name + "-- weibo_sex : " + weibo_sex+"�߳���:"+Thread.currentThread().getName());
    }

    @Test
    /**
     * ���̶߳���main�̶߳���Ĳ���,
     */
    public  void demo01() throws InterruptedException {
        final DirtyRead dr = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dr.setValue("��ԲԲ", "Ů");
            }
        });
        t1.start();
        dr.getValue();
        Thread.sleep(1000);
        dr.getValue();
        Thread.sleep(5000);
        dr.getValue();
    }

    @Test
    /**
     * ���̶߳���new Thread�̶߳���Ĳ���,�ᱨ��ָ��
     */
    public  void demo02() throws InterruptedException {
        DirtyRead dr=null;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                DirtyRead dr = new DirtyRead();
                 dr.setValue("��ԲԲ", "Ů");
            }
        });
        t1.start();
        dr.getValue();
        Thread.sleep(3000);
        dr.getValue();
        Thread.sleep(5000);
        dr.getValue();
    }



    @Test
    /**
     * ���̶߳Զ������Ĳ���,��������һֱ,����󲻴����̰߳�ȫ
     */
    public  void demo03() throws InterruptedException {
        DirtyRead dr=new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                DirtyRead dr = new DirtyRead();
                System.out.println(dr+"new Thread");
                dr.setValue("��ԲԲ", "Ů");
            }
        });
        t1.start();
        dr.getValue();
        Thread.sleep(3000);
        dr.getValue();
        Thread.sleep(5000);
        dr.getValue();
    }
}

