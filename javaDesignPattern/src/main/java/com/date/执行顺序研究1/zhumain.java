package com.date.执行顺序研究1;

/**
 * 静态代码块超级优先
 * 本类代码块优先构造
 * 静态方法访问,引用最近原则
 * 普通方法访问,对象最近原则
 */
public class zhumain {
    public static void main(String[] args) {
        System.out.println("=========  a a = new b();======================================");
        a a = new b();
        a.a1();
        a.a2();
        System.out.println("=========  b b= new b();======================================");
        b b= new b();
        b.a1();
        b.a2();
    }
}

