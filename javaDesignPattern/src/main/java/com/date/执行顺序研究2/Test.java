package com.date.ִ��˳���о�2;

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
        System.out.println(new Child());
        Object child1 = new Child();
        System.out.println(child1);


    }
}
class Father{
    public   String fuName="����";

    public static String getName(){
        return "Father";
    }


}
class Child extends Father{
    public String ziName="����";
    public static String getName(){
        return "Child";
    }

    @Override
    public String toString() {
        return "Child{" +
                "ziName='" + ziName + '\'' +
                ", fuName='" + fuName + '\'' +
                '}';
    }
}
