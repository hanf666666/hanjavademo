package com.InnerClass.StaticMainClass;

/**
 * to do
 *
 * @author Hj
 * @date 2023/2/23
 */
public class MainClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        System.out.println(outerClass);

        System.out.println("===========");
        OuterClass.InnerClass innerClass =  new OuterClass.InnerClass();

        System.out.println(outerClass);
    }
}
