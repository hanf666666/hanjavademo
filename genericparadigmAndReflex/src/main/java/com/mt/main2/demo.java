package com.mt.main2;

import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/6
 */
public class demo {
    public static void main(String[] args) {

        final List<Person> list = TUtils.getList(new Person());
        for (Person person1 : list) {
            System.out.println(person1);
        }
    }
}
