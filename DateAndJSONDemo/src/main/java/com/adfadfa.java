package com;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Hj
 * @date 2025/10/13
 */
public class adfadfa {
    public static void main(String[] args) {
        String ownerId="19768985847784612";
        String no="5eniqq1ok2s00002";
        //2147483647
        //395824097
        //1760409658
        //1064001
        System.out.println(DateUtil.date().getTime()/1000);
        Integer.parseInt(no.substring(no.length() - 3));
        System.out.println(getQualityNo(ownerId,1));
        System.out.println("===============");
        System.out.println(Integer.parseInt(String.valueOf(new Date().getTime()/1000)));
        System.out.println(2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2*2/86400/365);
    }

    /**
     * 传入相应的前缀生成指定长度（前补0）的自增No
     * @param profix       传入前缀
     * @param lastNo     上一次结束的No编号
     * @return 生成自增的编号
     */
    public static String getQualityNo(String profix,int lastNo) {
        AtomicInteger count = new AtomicInteger();
        count.set(lastNo);
        count.incrementAndGet();
        Integer nextNo = count.get();
        // 36进制（0-9a-z）
        String ownerId36 = Long.toString(Long.parseLong(profix), 36);

        //将新生成的编号格式化
        String resultNum =ownerId36+(String.format("%05d",nextNo.intValue()));
        return resultNum;
    }

}
