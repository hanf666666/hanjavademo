package com.print.线程安全.demo02;


public class ThreadA extends Thread{

    private Count count;

    public ThreadA(Count count){
        this.count=count;
    }

    public void run(){
        count.add("a", ThreadA.currentThread().getId());

    }
}
