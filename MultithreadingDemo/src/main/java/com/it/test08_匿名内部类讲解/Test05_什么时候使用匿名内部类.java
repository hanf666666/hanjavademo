package com.it.test08_�����ڲ��ི��;

public class Test05_ʲôʱ��ʹ�������ڲ��� {
    public static void main(String[] args) {
        //����: ����Inter#method1();

       Inter in =  new Inter() {
            @Override
           public void method1() {
               System.out.println("method1");
           }
           @Override
           public void method2() {
               System.out.println("method2");
           }
           @Override
           public void method3() {
               System.out.println("method3");
           }
           @Override
           public void method4() {
               System.out.println("method4");
           }
        };
       in.method1();

       //����: ��������Inner�ӿڵ��������.
    }
}

