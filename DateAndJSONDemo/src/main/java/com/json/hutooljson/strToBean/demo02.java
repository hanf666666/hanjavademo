package com.json.hutooljson.strToBean;

import javafx.util.Pair;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo02 {

    public static void main(String[] args) {


        Pair<Integer, String> pair = new Pair<>(1, "One");
        Integer key = pair.getKey();
        String value = pair.getValue();


        System.out.println(key+value);

    }
}