package com.date.date;

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
public class demo01 {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date todate = Dates.parse("2022-12-19", Dates.YYYY_MM_DD);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        todate = calendar.getTime();
        String yearDate = format.format(todate);
        System.out.println(yearDate);
//        30 * 24 * 60 * 60 * 1000*1000 +
        System.out.println("========"+System.currentTimeMillis());
        System.out.println("========"+(System.currentTimeMillis()+(30 * 24 * 60 * 60 * 1000)));
        System.out.println("======3=="+(30 * 24 * 60 * 60 * 1000L));
        System.out.println("======3=="+(30 * 24 * 60 * 60 * 1000));
        Date date = new Date(System.currentTimeMillis()+(30 * 24 * 60 * 60 * 1000L) );
        System.out.println("============"+ format.format(date));


    }
}
