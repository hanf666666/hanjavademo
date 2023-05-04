package com.gcdemo.demo03;

/**
 * to do
 * -verbose:gc
 * @author Hj
 * @date 2023/4/27
 */
public class demo03{
    public static void main(String [] args)throws InterruptedException{
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        byte[]arr= new byte[20*1024*1024];
        System.gc();
    }
}
