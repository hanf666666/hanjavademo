package com.CAS.myreentranlock3;


import sun.misc.Unsafe;
import sun.misc.VM;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.Field;

import static sun.misc.Unsafe.getUnsafe;

public class MyReentranLock {
    public static final Unsafe unsafe = getUnsafe();
    public static long stateoffset;
    static {
        try {
            stateoffset = unsafe.objectFieldOffset(MyReentranLock.class.getField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public volatile int state=0;
    public void lock(){
/*        boolean ischange = unsafe.compareAndSwapInt(this, stateoffset, 0, 1);
        if(ischange){
        }else{
            LockSupport.park();
        }*/


      while (!unsafe.compareAndSwapInt(this, stateoffset, 0, 1)){
          System.out.println(Thread.currentThread().getName()+"正在加锁");
      }
        System.out.println(Thread.currentThread().getName()+"加锁成功");
    }

    public void unlock(){
        state=0;
    }



    public static Unsafe getUnsafe() {
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
           theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}
