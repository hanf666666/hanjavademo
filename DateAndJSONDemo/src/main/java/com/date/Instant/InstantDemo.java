package com.date.Instant;

import java.time.Instant;

/**
 * @author Hj
 * @date 2025/12/4
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("从系统获取的当前时刻为："+now);
        Instant instant1= Instant.ofEpochMilli(0);
        System.out.println("计算机元年为："+instant1);
        Instant instant2= Instant.ofEpochSecond(60*60*24);
        System.out.println("计算机元年增加60*60*24秒后为："+instant2);
        Instant instant3= Instant.ofEpochMilli(1000*60*60*24);
        System.out.println("计算机元年增加1000*60*60*24毫秒后为："+instant3);
        System.out.println("获取秒值为："+Instant.parse("2023-04-25T16:18:33.44Z").getEpochSecond());
        System.out.println("获取纳秒值为："+Instant.parse("2023-04-25T16:18:33.44Z").getNano());
        System.out.println("从时间对象获取的Instant实例为："+Instant.from(now));

    }
}
