package com.gcdemo.demo02;

/**
 * to do
 * -verbose:gc
 * @author Hj
 * @date 2023/4/27
 */
public class demo02{
    public static void main(String [] args){
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        int a = 0;
        System.gc();
    }
}
