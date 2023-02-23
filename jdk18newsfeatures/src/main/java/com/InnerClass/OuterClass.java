package com.InnerClass;

/**
 * to do
 *
 * @author Hj
 * @date 2023/2/23
 */
public class OuterClass {
    private String name ;
    private int age;

    public class InnerClass{
        public InnerClass(){
            System.out.println("内部构造InnerClass");
            name = "cxuan";
            age = 25;
        }
        public void innerDemo(){
            System.out.println("innerDemo");
        }
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
