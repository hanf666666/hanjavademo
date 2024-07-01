package com.反射Demo.方式1;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/5
 */
public class demo01 {
    public static void main(String[] args) {
        Person aPerson = new Person();
        Class class1 = aPerson.getClass();
        try {
            Person c1 = aPerson.getClass().newInstance();
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
