package com.it.线程安全.demo02;



public class ThreadB extends Thread{

    private Count count;

    public ThreadB(Count count){
        this.count=count;
    }

    public void run(){
        count.add("b",ThreadB.currentThread().getId());
    }
}