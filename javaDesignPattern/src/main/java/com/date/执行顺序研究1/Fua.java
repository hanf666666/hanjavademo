package com.date.执行顺序研究1;

public class Fua {
    static {
        System.out.println("Fua的静态代码块new时执行,且一次  1111111111111");
    }
    public Fua(){
        System.out.println("Fua父构造 4444444444444444");
    }
    {
        System.out.println(" 代码块Fua  333333333");
    }
    static  void statica1(){
        System.out.println("我是Fua.a1静态方法");
    }
    public void a2(){
        System.out.println("我是Fua2普通方法");
    }


}