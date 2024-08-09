package com.base01.test08_匿名内部类讲解.innerclass;



/**
 * to do
 *
 * @author Hj
 * @date 2024/8/8
 */
public class Demo01 {
    public static void main(String[] args) {
//       OutClassInstance.InnerClass innerClass = new OutClassInstance().new InnerClass(); //注意是外部类实例.new，内部类

        OutClassInstance outClassInstance1 = new OutClassInstance();
        outClassInstance1.setOutName("setOutName111");
        //非静态内部类对象依赖于外部类对象而存在
        OutClassInstance.InnerClass innerClass = outClassInstance1.new InnerClass();
        innerClass.setInnerName("setInnerName111");
        System.out.println(innerClass);


        OutClassInstance outClassInstance = new OutClassInstance(); //注意是外部类实例.new，内部类
        outClassInstance.setOutName("setOutName1111");
        System.out.println(outClassInstance);

        //、静态内部类，内部类是静态的，那么它就是类级别的类成员了，不在依赖于对象而存在。所以静态内部类
        OutClassInstance.StaticInner staticInner = new OutClassInstance.StaticInner();
        staticInner.setInnerStaticName("setInnerStaticName1111");
        System.out.println(staticInner);



    }
}
