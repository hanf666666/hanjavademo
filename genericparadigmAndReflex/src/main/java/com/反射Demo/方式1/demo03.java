package com.∑¥…‰Demo.∑Ω Ω1;

import java.lang.reflect.Method;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/5
 */
public class demo03 {
    public static void main(String[] args) {
        Person aPerson = new Person();
        Class class1 = aPerson.getClass();
        try {
            Person c1 = aPerson.getClass().newInstance();
            String value = "12";
//            value = null;
            Method aMethod = Person.class.getDeclaredMethod("setAge", Integer.class);
            aMethod.invoke(c1, Integer.parseInt(value));
            c1.setAge(30);
//            aMethod.invoke(c1,java.lang.Integer.valueOf(value));
            System.out.println(c1.getAge());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
