package com.it.test05_多线程模拟卖票_出现的问题;

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

            //D: 为了让非法值的情况更明显, 我们加入: 休眠线程.
            try {     //线程1, 线程2, 线程3, 线程4
                Thread.sleep(50);  //特点, 在拿睡, 在哪醒.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //C: 走到这里, 说明有票, 正常卖
            //System.out.println(this.getName() +  "正在出售第" + tickets-- + "张票");
            System.out.println(getName() +  "正在出售第" + tickets-- + "张票");

            /*
                出现负数:  关键点在: if校验, sleep()方法.
                    线程1先执行: 正在买第1张票, 打印完毕后, tickets的值等于 0
                    线程2再执行: 正在买第0张票, 打印完毕后, tickets的值等于 -1
                    线程3再执行: 正在买第-1张票, 打印完毕后, tickets的值等于 -2
                    线程4再执行: 正在买第-2张票, 打印完毕后, tickets的值等于 -3
             */

            /*
                重复值: 关键点: tickets--
                    tickets-- 相当于  tickets = tickets - 1;
                    A: 读值. 读取tickets的值.
                    B: 改值. 将tickets的值-1
                    C: 赋值. 将tickets-1后的新值重新赋值给tickets.

                    还没有来得及执行C的之后, 被别的线程抢走资源了.

             */
        }
    }
}
