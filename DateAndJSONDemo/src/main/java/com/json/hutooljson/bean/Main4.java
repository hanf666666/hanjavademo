package com.json.hutooljson.bean;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/15
 */
public class Main4 {
    public static void main(String[] args) {

         Result<Student> result=null;
        String str= "{\"code\":\"200.0\",\"message\":\"业务成功\",\"localizedMsg\":\"null\",\"data\":{\"carStock\":\"0.0\",\"plateNo\":\"渝A1LZ91\",\"shouldPay\":\"10.0\",\"discountAmount\":\"0.0\",\"paidType\":\"2.0\",\"dealTime\":\"2024-03-26 11:12:57\",\"billID\":\"2403261111239879012\",\"orderCode\":\"\",\"askOrderTime\":\"2024-03-26 11:12:56\",\"payStatus\":\"1.0\",\"actualPay\":\"10.0\"}}\n";
        Result bean = JSONUtil.toBean(str, Result.class);
        System.out.println("bean===="+bean);
    }
}
