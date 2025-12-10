package com.∑¥…‰Demo.∑Ω Ω1;

/**
 * @author Hj
 * @date 2025/12/9
 */
public class Demo_01 {
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
