package com.newsfeatures.LocalDate;

import java.time.*;
import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/5
 */
public class demo {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.now());
        System.out.println(new Date());
        System.out.println(new Date().toInstant());



        System.out.println("-------------------------------------");

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println("OffsetDateTime.now().getOffset()===>"+OffsetDateTime.now().getOffset());
        System.out.println(LocalDateTime.now().atOffset(OffsetDateTime.now().getOffset()).toEpochSecond());
        System.out.println(LocalDateTime.now().atOffset(OffsetDateTime.now().getOffset()).toInstant().getEpochSecond());
        System.out.println(LocalDateTime.now().atOffset(OffsetDateTime.now().getOffset()).toInstant().toEpochMilli());

        System.out.println("========================================");

        Instant instant = Instant.now();
        System.out.println(new Date(instant.getEpochSecond()*1000));
        System.out.println(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
    }


//½á¹û
//1641346236231
//2022-01-05T09:30:36.293
//1641346236
//2022-01-05T01:30:36.293Z
//Wed Jan 05 09:30:36 CST 2022
//2022-01-05T01:30:36.311Z
//-------------------------------------
//1641346236311
//1641346236
//1641346236
//1641346236312
//1641346236
//1641346236
//1641346236313
//========================================
//Wed Jan 05 09:30:36 CST 2022
//2022-01-05T09:30:36.313


}
