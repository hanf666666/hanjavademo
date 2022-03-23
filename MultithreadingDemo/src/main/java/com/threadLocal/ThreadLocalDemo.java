package com.threadLocal;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/22
 */
public class ThreadLocalDemo {
    public static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

        integerThreadLocal.set(30);

        System.out.println(getThreadLocal());



    }

    private static Integer getThreadLocal() {
       return integerThreadLocal.get();
    }

}
