package com.mt.entity.LocalDate;

import cn.hutool.core.date.DateUtil;

import java.time.*;
import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/5
 */
public class demo2 {
    public static void main(String[] args) {
        System.out.println(DateUtil.date());
        System.out.println(DateUtil.toLocalDateTime(DateUtil.date()));
        System.out.println(DateUtil.toLocalDateTime(new Date()));
        System.out.println(LocalDateTime.now());

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
