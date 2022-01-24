package com.metaspace;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/24
 */
public class NonHeapMain {

    public static void main(String[] args) {
        /**
         * 模拟元空间内存溢出 -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
         * Exception in thread "http-nio-8080-exec-1" java.lang.OutOfMemoryError: Metaspace
         */
        List<Class<?>> classList = new ArrayList<Class<?>>();
        int i = 0;
        while (true) {
            System.out.println(1000*(i++));
            classList.addAll(MetaSpace.createClasses());
        }

    }
}
