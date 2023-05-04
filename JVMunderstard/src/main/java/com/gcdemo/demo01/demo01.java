package com.gcdemo.demo01;

/**
 * to do
 * -verbose:gc
 * @author Hj
 * @date 2023/4/27
 */
public class demo01 {

    public static void main(String [] args){
        byte[] placeholder = new byte[64*1024*1024];
        System.gc();
    }
}
