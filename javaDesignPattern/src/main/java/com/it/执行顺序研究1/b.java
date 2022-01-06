package com.it.执行顺序研究1;
public class b extends a
{
    static {
        System.out.println("b的静态代码块new时执行,且一次   2222222222");
    }
    {
        System.out.println("代码块b   555555555555555555555");
    }
    b(){
        super();
        System.out.println("子构造 666666666666666666666");
    }
    static  void a1(){
        System.out.println("我是继承b1静态方法==>特殊");
    }
    public void a2(){
        System.out.println("我是继承b2普通方法");
    }


}
