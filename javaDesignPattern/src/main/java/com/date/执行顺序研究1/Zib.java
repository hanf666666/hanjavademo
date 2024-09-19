package com.date.执行顺序研究1;
public class Zib extends Fua
{
    public String ziName;
    static {
        System.out.println("Zib的静态代码块new时执行,且一次   2222222222");
    }
    {
        System.out.println("代码块Zib   555555555555555555555");
    }
    Zib(){
        super();
        System.out.println("Zib子构造 666666666666666666666");
    }
    static  void statica1(){
        System.out.println("我是继承Zib.b1静态方法==>特殊");
    }
    public void a2(){

        System.out.println("我是继承Zib.b2普通方法");
    }


}
