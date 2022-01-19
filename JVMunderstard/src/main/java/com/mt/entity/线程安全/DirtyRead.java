package com.mt.entity.线程安全;

import org.junit.Test;

public class DirtyRead {
    private String weibo_name = "刘德华";
    private String weibo_sex = "男";

    public  void setValue(String weibo_name, String weibo_sex) {
        synchronized(this){
        this.weibo_name = weibo_name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.weibo_sex = weibo_sex;
        System.out.println("我是设置方法    setValue---------weibo_name :" + weibo_name +
                "-- weibo_sex : " + weibo_sex+"线程名:"+Thread.currentThread().getName());

    }
    }


    public void getValue() {
        System.out.println("我是获取方法   getValue---------weibo_name :" +
                weibo_name + "-- weibo_sex : " + weibo_sex+"线程名:"+Thread.currentThread().getName());
    }

    @Test
    /**
     * 多线程对主main线程对像的操作,
     */
    public  void demo01() throws InterruptedException {
        final DirtyRead dr = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dr.setValue("高圆圆", "女");
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
     * 多线程对主new Thread线程对像的操作,会报空指针
     */
    public  void demo02() throws InterruptedException {
        DirtyRead dr=null;
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                DirtyRead dr = new DirtyRead();
                 dr.setValue("高圆圆", "女");
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
     * 多线程对多个对像的操作,但是名字一直,多对象不存在线程安全
     */
    public  void demo03() throws InterruptedException {
        DirtyRead dr=new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                DirtyRead dr = new DirtyRead();
                System.out.println(dr+"new Thread");
                dr.setValue("高圆圆", "女");
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

