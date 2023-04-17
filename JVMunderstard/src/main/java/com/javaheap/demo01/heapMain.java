package com.javaheap.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * to do
 -Xms32m
 -Xmx32m
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:HeapDumpPath=D:\softwares\study\javaJvm\MemoryAnalyzer-1.12.0.20210602-win32.win32.x86_64\dump_test\1
 * @author Hj
 * @date 2022/1/24
 */
public class heapMain {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        /**
         * 模拟堆内存溢出的情况 -Xms32M -Xmx32M
         * Exception in thread "http-nio-8080-exec-1" java.lang.OutOfMemoryError: GC overhead limit exceeded
         */
        int i = 0;
        while (true){
            System.out.println(i);
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }
}
