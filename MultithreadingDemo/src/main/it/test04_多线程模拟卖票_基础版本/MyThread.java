package com.it.test04_多线程模拟卖票_基础版本;

/**
 * 自定义的线程类, 模拟卖票
 */
public class MyThread extends Thread{

    /*
        思路:
            1. 定义变量, 记录共享的100张票.
            2. 在run()方法中实现, 卖票的动作.
            3. 在测试类中, 创建4个线程, 卖票.
     */
    //1
   private static int tickets = 100;          //共享

    //构造方法
    //alt + insert


    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    //2
    @Override
    public void run() {
        /*
            卖票的动作:
                A: 因为不知道什么时候卖完, 所以用while(true).
                B: 做一个非法值校验, 如果没票了, 就不卖了.
                C: 正常的卖票逻辑.
         */
        //A
        while(true) {
            if (tickets < 1) {
                //B: 能走这里, 说明没票了
                break;
            }

            //C: 走到这里, 说明有票, 正常卖
            //System.out.println(this.getName() +  "正在出售第" + tickets-- + "张票");
            System.out.println(getName() +  "正在出售第" + tickets-- + "张票");
        }
    }
}
