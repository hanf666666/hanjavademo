package com.date.Ö´ÐÐË³ÐòÑÐ¾¿2;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/13
 */
public class Test {
    public static void main(String[] args){
        Father father = new Father();
        Father child = new Child();
        System.out.println(father.getName());
        System.out.println(child.getName());
    }
}
class Father{
    public static String getName(){
        return "Father";
    }
}
class Child extends Father{
    public static String getName(){
        return "Child";
    }
}
