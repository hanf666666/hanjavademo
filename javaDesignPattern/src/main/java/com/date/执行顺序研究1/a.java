package com.date.执行顺序研究1;

public class a{
    static {
        System.out.println("a的静态代码块new时执行,且一次  1111111111111");
    }
    public a(){
        System.out.println("父构造 4444444444444444");
    }
    {
        System.out.println(" 代码块a  333333333");
    }
    static  void a1(){
        System.out.println("我是a1静态方法");
    }
    public void a2(){
        System.out.println("我是a2普通方法");
    }


}