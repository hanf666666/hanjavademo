package com.newsfeatures.线程安全.demo01;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//理解脏读锁难
public class DirtyRead {
    private String weibo_name = "刘德华" ;
    private String weibo_sex = "男" ;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public   void setValue(String weibo_name , String weibo_sex){
        lock.writeLock().lock();
        //synchronized锁不住两个方法
//        getValue---------weibo_name :高圆圆-- weibo_sex : 男
//        setValue---------weibo_name :高圆圆-- weibo_sex : 女
      //  synchronized//枷锁与不枷锁没区别
//        getValue---------weibo_name :高圆圆-- weibo_sex : 男
//        setValue---------weibo_name :高圆圆-- weibo_sex : 女
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
                dr.setValue("高圆圆" , "女");
            }
        }) ;
        t1.start();
        Thread.sleep(1000);
        dr.getValue();
    }
}
