package com.base01.test07_多线程模拟卖票_实现Runnable接口版;

public class MyRunnable implements  Runnable{
    //1. 定义变量,  记录票数.
    private int tickets = 100;       //static可以不可以不写? 可以


    //2. 在run中模拟卖票.
    @Override
    public void run() {
        while(true) {
            //该类的字节码文件对象,   这里的this其实就是(mr)
           synchronized (this) {
               if (tickets < 1) {
                   break;
               }
               //为了让效果更明显.
               try {
                   Thread.sleep(50);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               //正常的卖票的逻辑
               System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
           }
        }
    }
}
