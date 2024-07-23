package com.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * to do
 * 1）ArrayList线程不安全但是效率高，Vector安全但是效率不高。
 * @author Hj
 * @date 2024/7/23
 */
public class Test02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synlist = Collections.synchronizedList(new ArrayList<>());

        list.add("111111111");
        list.add("111111111");
        synlist.add("111111111");
        synlist.add("111111111");

        Vector<String> vector = new Vector<>();
        vector.add("111111111");

        System.out.println("list.size() = " + list.size());
        System.out.println("synlist.size() = " + synlist.size());
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("vector = " + vector);




    }
}
