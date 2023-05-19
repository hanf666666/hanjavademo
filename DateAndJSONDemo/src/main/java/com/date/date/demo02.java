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
public class demo02 {
    //2023-06
    //2022-06
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +1);

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.MONTH, -11);
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        //本月
        String thisMonth = dft.format(cal.getTime());
        //本月-12个月
        String minMonth = dft.format(cal1.getTime());

        System.out.println(thisMonth);
        System.out.println(minMonth);


    }
}
