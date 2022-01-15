package com.print.主线程等子线程.while循环;

import java.util.concurrent.locks.ReentrantLock;

public class StaticValue {
    public static ReentrantLock reentrantLock= new ReentrantLock();
    public static Integer count=0;
}
