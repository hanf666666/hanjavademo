package com.date.date;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/19
 */
@Slf4j
public class demo04 {
    public static void main(String[] args) {
        Date now = new Date();
        //设定时间为
        String s = "  10:48:00";
        String sa = "  14:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(now);
        String afterDate = format.format(now);
        str = str + s;
        afterDate = afterDate + sa;
        SimpleDateFormat sdf = new SimpleDateFormat(Dates.YYYY_MM_DD_HH_MM_SS);
        Date dates = new Date();
        Date date = new Date();
        Date after = new Date();
        Date befor = new Date();
        //获取昨日
//        DateUtil.date().offset(DateField.DAY_OF_YEAR,-1).toDateStr()+sa;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dates);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        dates = calendar.getTime();
        String yearDate = format.format(dates);
        //获取昨天两点钟
        String next = yearDate + sa;
        try {
            //获取时间当天10.48
            date = sdf.parse(str);
            //时间为当天14：00
            after = sdf.parse(afterDate);
            //获取时间为昨天14:00
            befor = sdf.parse(next);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("{}",date);
        log.info("{}",after);
        log.info("{}",befor);
        log.info("{}",now.before(date));




    }
}
