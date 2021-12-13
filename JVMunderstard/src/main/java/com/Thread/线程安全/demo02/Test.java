package com.Thread.线程安全.demo02;

/**
 * 200,  b 12
   200, a   11
 产生原因是,当a线程执行add方法时,进入
 if("a".equals(str)){
 count=100;//并且赋值了100,但此时线程被休眠3s
 这时线程b出来了,并对 count=200;,并打印,这句话200,  b 12
 这是a线程苏醒了,但是count=100被复值位200  ,则打印了200, a   11
 方法锁,是该段时间只有该对象的一个线程访问该方法
 类锁,是该段时间只有该类的一个线程访问该方法
 就是说,类锁>对象锁


 */
public class Test {
    public static void main(String[] args) {
        Count count=new Count();
        ThreadA a=new ThreadA(count);
        a.start();

        ThreadB b=new ThreadB(count);
        b.start();
    }
}