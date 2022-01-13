package com.date.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * to do
 * 放着能不用就不用,hutool替代
 *
 * @author Hj
 * @date 2022/1/4
 */
public class DateUtils {

    public static final String CHINESE_DATE_FORMAT_LINE = "yyyy-MM-dd";
    public static final String CHINESE_DATETIME_FORMAT_LINE = "yyyy-MM-dd HH:mm:ss";
    public static final String CHINESE_DATE_FORMAT_SLASH = "yyyy/MM/dd";
    public static final String CHINESE_DATETIME_FORMAT_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String CHINESE_DATETIME_FORMAT_SLASH_HM = "yyyy/MM/dd HH:mm";
    public static final String DATETIME_NOT_SEPARATOR = "yyyyMMddHHmmssSSS";
    public static final String CHINESE_DATETIME_FORMAT_LINE_HM = "yyyy-MM-dd HH:mm";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYY_MM_DD_HH_MM = "yyyy/MM/dd/HH/mm";
    public final static String HH_MM_SS = "HH:mm:ss";
    public final static String HHMMSS = "HHmmss";
    public final static String YYYYMMDD = "yyyyMMdd";
    public final static String YYYYMMDDHHmmss = "yyyyMMddHHmmss";
    public final static long DAY_MILLI_SECOND = 24 * 60 * 60 * 1000;
    public final static long HOURS_MILLI_SECOND = 60 * 60 * 1000;
    public final static long MINUTES_MILLI_SECOND = 60 * 1000;
    public final static long SECOND_MILLI_SECOND = 1000;


    public static String format(Date date, String pattern) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * LocalDateTime转为"yyyy/MM/dd"
     *
     * @param date
     * @return java.lang.String
     * @author tianhf
     * @date 2019/11/19
     */
    public static String formatLocalDateTimeString(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(CHINESE_DATE_FORMAT_LINE);
        return date.format(dtf);
    }

    /**
     * LocalDateTime转为"yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return java.lang.String
     * @author tianhf
     * @date 2019/11/19
     */
    public static String formatLocalDateTimeString1(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(CHINESE_DATETIME_FORMAT_LINE);
        return date.format(dtf);
    }

    /**
     * Date转为"yyyy/MM/dd"
     *
     * @param date
     * @return
     * @author tianhf
     * @date 2019/11/19
     */
    public static String formatDateTimeString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(CHINESE_DATE_FORMAT_LINE);
        return df.format(date);
    }

    /**
     * Date转为"yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return java.lang.String
     * @author tianhf
     * @date 2019/11/19
     */
    public static String formatDateTimeString1(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(CHINESE_DATETIME_FORMAT_LINE);
        return df.format(date);
    }

    /**
     * 字符串"yyyy-MM-dd HH:mm:ss"转LocalDateTime
     *
     * @param date 字符串"yyyy-MM-dd HH:mm:ss"
     * @return LocalDateTime对象
     */
    public static LocalDateTime getLocalDateTime(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(CHINESE_DATETIME_FORMAT_LINE);
        LocalDateTime localDateTime = LocalDateTime.parse(date, df);
        return localDateTime;
    }

    /**
     * long类型秒时间 装换为 localDateTime
     *
     * @param seconds
     * @return
     */
    public static LocalDateTime getLocalDateTime(Long seconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
    }

    /**
     * Date转为"yyyyMMddHHmmssSSS"
     *
     * @param date
     * @return java.lang.String
     * @author tianhf
     * @date 2019/11/19
     */
    public static String formatDateTimeString2(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(DATETIME_NOT_SEPARATOR);
        return df.format(date);
    }

    /**
     * Date转为"yyyyMMddHHmmss"
     *
     * @param date
     * @return java.lang.String
     * @author tianhf
     * @date 2019/11/19
     */
    public static String formatDateTimeYYYYMMDDHHmmss(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(YYYYMMDDHHmmss);
        return df.format(date);
    }

    /**
     * "yyyy-MM-dd HH:mm:ss" 转为Date
     *
     * @param dateStr
     * @return java.util.Date
     * @author tianhf
     * @date 2020/4/27
     */
    public static Date String2Date(String dateStr) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(CHINESE_DATETIME_FORMAT_LINE);
        return sf.parse(dateStr);
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 计算两个时间的差值
     *
     * @param startDate
     * @param endDate
     * @param timeUnit
     * @return
     */
    public static Long durationOfDate(Date startDate, Date endDate, TimeUnit timeUnit) {
        long minusMicroSseconds = endDate.getTime() - startDate.getTime();
        switch (timeUnit) {
            case MICROSECONDS:
                return minusMicroSseconds;
            case SECONDS:
                return minusMicroSseconds / 1000;
            case MINUTES:
                return minusMicroSseconds / (1000 * 60);
            case HOURS:
                return minusMicroSseconds / (1000 * 60 * 60);
            case DAYS:
                return minusMicroSseconds / (1000 * 60 * 60 * 24);
            case MILLISECONDS:
                return minusMicroSseconds * 1000;
            case NANOSECONDS:
                return minusMicroSseconds * 1000 * 1000;
            default: {
            }
        }
        return null;
    }

    /**
     * 计算两个时间的差值
     *
     * @param startDateStr yyyy-MM-dd HH:mm:ss
     * @param endDateStr   yyyy-MM-dd HH:mm:ss
     * @param timeUnit
     * @return
     */
    public static Long durationOfDate(String startDateStr, String endDateStr, TimeUnit timeUnit) {
        try {
            Date startDate = String2Date(startDateStr);
            Date endDate = String2Date(endDateStr);
            return durationOfDate(startDate, endDate, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

}
