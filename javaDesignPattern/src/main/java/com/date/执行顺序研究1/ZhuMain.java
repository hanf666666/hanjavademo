package com.date.执行顺序研究1;

/**
 * 静态代码块超级优先
 * 本类代码块优先构造
 * 静态方法访问,引用最近原则
 * 普通方法访问,对象最近原则
 */
public class ZhuMain {
    public static void main(String[] args) {
        System.out.println("=========  Fua Fua = new Zib();======================================");
        Fua a = new Zib();
        a.statica1();
        a.a2();
        System.out.println("=========  Zib Zib= new Zib();======================================");
        Zib b= new Zib();
        b.statica1();
        b.a2();
    }
}

