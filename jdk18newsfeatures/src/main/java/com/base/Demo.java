package com.base;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/28
 */
public class Demo {
    public static void main(String[] args) {
        //һ�ֽ�8λ  ==Integer����4�ֽ�32λ
        final int COUNT_BITS = Integer.SIZE;
        System.out.println(COUNT_BITS);

        //1=00000001=2^0
        //1 << 1 =2=00000010=2^1
        //1 << 2 =4=000000100=2^2
        int CAPACITY   =1 << 2;
        System.out.println(CAPACITY);


        CAPACITY   = (1 << 29) - 1;
        System.out.println(CAPACITY);
        System.out.println("&��->");
        CAPACITY   =  31 & 32;
        System.out.println(CAPACITY);
        CAPACITY   =  32 & 32;
        System.out.println(CAPACITY);


        System.out.println("��|->");
        CAPACITY   =  31 | 32;
        System.out.println(CAPACITY);
        CAPACITY   =  32 | 32;
        System.out.println(CAPACITY);
        System.out.println("�η�->");
        //2,147,483,647
        //2.147483648E9
        System.out.println(Math.pow(2,31));
    }
}
