package com.threadLocal;

import java.util.HashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/22
 */
public class ThreadLocalDemo {
    public static ThreadLocal<HashMap> integerThreadLocal = new ThreadLocal< HashMap>();
    public static void main(String[] args) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1","����1");
        stringStringHashMap.put("2","����2");
        stringStringHashMap.put("3","����3");
        integerThreadLocal.set(stringStringHashMap);
        HashMap<String, String> stringStringHashMap2 = new HashMap<>();
        stringStringHashMap2.put("1","����1");
        stringStringHashMap2.put("2","����2");
        stringStringHashMap2.put("3","����3");
        stringStringHashMap2.put("4","����4");
        integerThreadLocal.set(stringStringHashMap2);
        integerThreadLocal.remove();
        System.out.println(getThreadLocal().toString());



    }

    private static HashMap getThreadLocal() {
        HashMap hashMap = integerThreadLocal.get();
        return hashMap;
    }

}
