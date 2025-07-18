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
        //�趨ʱ��Ϊ
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
        //��ȡ����
//        DateUtil.date().offset(DateField.DAY_OF_YEAR,-1).toDateStr()+sa;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dates);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        dates = calendar.getTime();
        String yearDate = format.format(dates);
        //��ȡ����������
        String next = yearDate + sa;
        try {
            //��ȡʱ�䵱��10.48
            date = sdf.parse(str);
            //ʱ��Ϊ����14��00
            after = sdf.parse(afterDate);
            //��ȡʱ��Ϊ����14:00
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
