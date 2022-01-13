package com.mt.main2;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/6
 */
public class TUtils {
    public static <T> List<T> getList(T obj){
        final ArrayList<T> tList = new ArrayList<>();

        final ArrayList<Person> peopleArrayList = new ArrayList<>();
        peopleArrayList.add(new Person("han1"));
        peopleArrayList.add(new Person("han2"));

        peopleArrayList.forEach((person -> {
            tList.add((T) person);
        }));

        return tList;
    }
}
