package com.InnerClass.StaticMainClass;

/**
 * to do
 * ��̬�ڲ���
 * @author Hj
 * @date 2023/2/23
 */
public class OuterClass {
    private String name ;
    private int age;

    public static class InnerClass{
        public InnerClass(){
            System.out.println("�ڲ�����InnerClass");

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
