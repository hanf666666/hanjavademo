package com.newsfeatures.�̰߳�ȫ.demo01;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//����������
public class DirtyRead {
    private String weibo_name = "���»�" ;
    private String weibo_sex = "��" ;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public   void setValue(String weibo_name , String weibo_sex){
        lock.writeLock().lock();
        //synchronized����ס��������
//        getValue---------weibo_name :��ԲԲ-- weibo_sex : ��
//        setValue---------weibo_name :��ԲԲ-- weibo_sex : Ů
      //  synchronized//�����벻����û����
//        getValue---------weibo_name :��ԲԲ-- weibo_sex : ��
//        setValue---------weibo_name :��ԲԲ-- weibo_sex : Ů
        this.weibo_name = weibo_name ;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.weibo_sex = weibo_sex ;
        System.out.println("setValue---------weibo_name :" + weibo_name + "-- weibo_sex : "+weibo_sex);
        lock.writeLock().unlock();
    }
    public void getValue(){
        lock.readLock().lock();
        System.out.println("getValue---------weibo_name :" + weibo_name + "-- weibo_sex : "+weibo_sex);

        lock.readLock().unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        final DirtyRead dr = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dr.setValue("��ԲԲ" , "Ů");
            }
        }) ;
        t1.start();
        Thread.sleep(1000);
        dr.getValue();
    }
}
