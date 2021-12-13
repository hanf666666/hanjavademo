package com.CAS.demo;

import java.util.concurrent.locks.ReentrantLock;

public class StaticValue {
    public static ReentrantLock reentrantLock= new ReentrantLock();
    public static Integer count=1;
}
