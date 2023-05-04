package com.javaheap.demo03ThreadLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * to do
 -Xms32m
 -Xmx32m
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:HeapDumpPath=D:\softwares\study\javaJvm\MemoryAnalyzer-1.12.0.20210602-win32.win32.x86_64\dump_test\heapMainThreadLocal\
 * @author Hj
 * @date 2022/1/24
 */
public class heapMainThreadLocal {
    public static ThreadLocal<List<User>> userListThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread.currentThread().setName("han_ThreadLocal");
        /**
         * 模拟堆内存溢出的情况 -Xms32M -Xmx32M
         * Exception in thread "http-nio-8080-exec-1" java.lang.OutOfMemoryError: GC overhead limit exceeded
         */
        List<User> userList =new ArrayList<>();
        User2 user2 = new User2();
        List<User2> userList2 =new ArrayList<>();
        List<User2> userList3 =new ArrayList<>();
        List<User2> userList4 =new ArrayList<>();
        userListThreadLocal.set(userList);
        int i = 0;
        while (true){
            userList.add(new User(i++, UUID.randomUUID().toString()));
            userList2.add(user2);
            userList3.add(user2);
            userList4.add(user2);
        }

    }
}
