package com.date.date;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * 简单 Date 相关静态工具
 */
public class Dates {

    public static final String CHINESE_DATE_FORMAT_LINE = "yyyy-MM-dd";
    public static final String CHINESE_DATETIME_FORMAT_LINE = "yyyy-MM-dd HH:mm:ss";
    public static final String CHINESE_DATE_FORMAT_SLASH = "yyyy/MM/dd";
    public static final String CHINESE_DATETIME_FORMAT_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String DATETIME_NOT_SEPARATOR = "yyyyMMddHHmmssSSS";
    public static final String CHINESE_DATETIME_FORMAT_LINE_HM = "yyyy-MM-dd HH:mm";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String HH_MM_SS = "HH:mm:ss";
    public final static String HHMMSS = "HHmmss";
    public final static String YYYYMMDD = "yyyyMMdd";
    public final static String YYYYMMDDHHmm = "yyyyMMddHHmm";
    public final static long DAY_MILLI_SECOND = 24 * 60 * 60 * 1000;
    public final static long HOURS_MILLI_SECOND = 60 * 60 * 1000;
    public final static long MINUTES_MILLI_SECOND = 60 * 1000;
    public final static long SECOND_MILLI_SECOND = 1000;

    private static final String[] SUPPORT_ALL_FORMATS = new String[]{CHINESE_DATE_FORMAT_LINE,
            CHINESE_DATETIME_FORMAT_LINE, CHINESE_DATE_FORMAT_SLASH, CHINESE_DATETIME_FORMAT_SLASH};

    private static final String DEFAULT_DATE_FORMAT = CHINESE_DATETIME_FORMAT_LINE;

    private static DateTimeFormatter dateTimeFormatter;

    private static LocalDateTime localDateTime;

    private final static Calendar c = Calendar.getInstance();

    public static String format(Date date, String pattern) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        localDateTime = instant.atZone(zoneId).toLocalDateTime();
        dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(localDateTime);
    }

    public static String format(Date date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    public static String format(String pattern) {
        return format(new Date(), pattern);
    }

    public static Date parse(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateString);
        } catch (Exception e) {
            throw new RuntimeException("parse String[" + dateString + "] to Date faulure with timePattern[" + pattern
                    + "].");
        }
    }

    public static Date parse(Date date, String pattern) {
        SimpleDateFormat tmpSdf = new SimpleDateFormat(pattern);
        String tmpDate = tmpSdf.format(date);
        try {
            return tmpSdf.parse(tmpDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parse(String dateString, String[] patterns) {
        for (String pattern : patterns) {
            if (StringUtils.isBlank(pattern)) {
                continue;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                return sdf.parse(dateString);
            } catch (Exception e) {
                // ignore exception
                continue;
            }
        }
        throw new UnsupportedOperationException("Parse String[" + dateString + "] to Date faulure with patterns["
                + Arrays.toString(patterns) + "]");

    }

    public static Date parse(String dateString) {
        return parse(dateString, SUPPORT_ALL_FORMATS);
    }

    public static Date addDay(Date date) {
        long oneDayMillisecond = 24 * 60 * 60 * 1000;
        return addDate(date, oneDayMillisecond);
    }

    public static Date minusDay(Date date) {
        long oneDayMillisecond = 24 * 60 * 60 * 1000;
        return addDate(date, -oneDayMillisecond);
    }

    public static Date addDate(Date date, long millisecond) {
        return new Date(date.getTime() + millisecond);
    }

    /**
     * date to string with format
     *
     * @param date
     * @param format
     * @return
     */
    public static String toString(Date date, String format) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        } else {
            return null;
        }
    }

    /**
     * @param time
     * @param format
     * @return
     */
    public static String toString(long time, String format) {
        Timestamp t = new Timestamp(time);
        return toString(t, format);
    }

    /**
     * @param timestamp
     * @param format
     * @return
     */
    public static String toString(Timestamp timestamp, String format) {
        if (timestamp != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(timestamp);
        } else {
            return null;
        }
    }

    /**
     * @return
     */
    public static String today() {
        return toString(new Date(), YYYY_MM_DD);
    }

    /**
     * @return
     */
    public static String today(String format) {
        return toString(new Date(), format);
    }


    public static Date todayStartDate() {
        String time = Dates.today();
        Date date = Dates.parse(time);
        return date;
    }

    /**
     * @param dateStr
     * @param format
     * @return
     */
    public static Timestamp toTimestamp(String dateStr, String format) throws IllegalArgumentException {
        if (dateStr != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                Date d = df.parse(dateStr);
                if (d != null) {
                    return new Timestamp(d.getTime());
                }
            } catch (ParseException e) {
                throw new IllegalArgumentException(":::[toTimestamp]parse [" + dateStr + "] error, format[" + format + "]");
            }
        }
        return null;
    }

    /**
     * @param dateStr
     * @param format
     * @return
     */
    public static long toLong(String dateStr, String format) {
        Timestamp t = toTimestamp(dateStr, format);
        if (t != null) {
            return t.getTime();
        } else {
            return 0L;
        }
    }

    /**
     * @return
     */
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @param t
     * @return
     */
    public static int getMinute(Timestamp t) {
        if (t == null) {
            return 0;
        }
        synchronized (c) {
            c.setTime(t);
            return c.get(Calendar.MINUTE);
        }
    }

    /**
     * @param t
     * @return
     */
    public static int getHour24(Timestamp t) {
        if (t == null) {
            return 0;
        }
        synchronized (c) {
            c.setTime(t);
            return c.get(Calendar.HOUR_OF_DAY);
        }
    }

    /**
     * 2010.9.3 11:00:00
     *
     * @return
     */
    public static Timestamp hourStart() {
        return hourStart(new Date(), 0);
    }


    /**
     * 2010.9.3 11:59:59
     *
     * @return
     */
    public static Timestamp hourEnd() {
        return hourEnd(new Date(), 0);
    }

    /**
     * @param date
     * @param hoursOffset
     * @return
     */
    public static Timestamp hourEnd(Date date, int hoursOffset) {
        synchronized (c) {
            c.setTime(date);
            //---------------------------------------
            c.add(Calendar.HOUR, hoursOffset);
            //---------------------------------------
            c.add(Calendar.HOUR_OF_DAY, 1);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.add(Calendar.SECOND, -1);
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * @param date
     * @param hoursOffset
     * @return
     */
    public static Timestamp hourStart(Date date, int hoursOffset) {
        synchronized (c) {
            c.setTime(date);
            //---------------------------------------
            c.add(Calendar.HOUR, hoursOffset);
            //---------------------------------------
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp dayStart(Date date) {
        return dayStart(date, 0);
    }

    /**
     * @param date
     * @param dayOffset
     * @return
     */
    public static Timestamp dayStart(Date date, int dayOffset) {
        synchronized (c) {
            c.setTime(date);
            //---------------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //---------------------------------------
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp dayEnd(Date date, int dayOffset) {
        synchronized (c) {
            c.setTime(date);
            //---------------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //---------------------------------------
            c.add(Calendar.DAY_OF_YEAR, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.add(Calendar.SECOND, -1);
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp dayEnd(Date date) {
        return dayEnd(date, 0);
    }

    /**
     * 2010.9.3 00:00:00
     *
     * @return
     */
    public static Timestamp todayStart() {
        return dayStart(new Date());
    }


    /**
     * 2010.9.3 23:59:59
     *
     * @return
     */
    public static Timestamp todayEnd() {
        return dayEnd(new Date());
    }


    /**
     * @param date
     * @return
     */
    public static Timestamp monthStart(Date date) {
        return monthStart(date, 0);
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp monthStart(Date date, int dayOffset) {
        synchronized (c) {
            c.setTime(date);
            //-----------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //-----------------------------------
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp monthEnd(Date date) {
        return monthEnd(date, 0);
    }

    /**
     * 2010.10.3 -> 2010.11.1 -> 2010.10.31
     *
     * @param date
     * @return
     */
    public static Timestamp monthEnd(Date date, int dayOffset) {
        synchronized (c) {
            c.setTime(date);
            //-----------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //-----------------------------------
            c.add(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.add(Calendar.SECOND, -1);
            //------------------------------------

            //------------------------------------
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * 2010.9.1 00:00:00
     *
     * @return
     */
    public static Timestamp monthStart() {
        return monthStart(new Date());
    }

    /**
     * 2010.9.30 23:59:59
     *
     * @return
     */
    public static Timestamp monthEnd() {
        return monthEnd(new Date());
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp yearStart(Date date) {
        return yearStart(date, 0);
    }

    /**
     * @param date
     * @return
     */
    public static Timestamp yearStart(Date date, int dayOffset) {
        synchronized (c) {
            c.setTime(date);
            //-----------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //-----------------------------------
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return new Timestamp(c.getTimeInMillis());
        }

    }

    /**
     * @param date
     * @return
     */
    public static Timestamp yearEnd(Date date) {
        return yearEnd(date, 0);
    }

    /**
     * @param date
     * @param dayOffset
     * @return
     */
    public static Timestamp yearEnd(Date date, int dayOffset) {
        synchronized (c) {
            c.setTime(date);
            //-----------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //-----------------------------------
            c.add(Calendar.YEAR, 1);
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.add(Calendar.SECOND, -1);
            return new Timestamp(c.getTimeInMillis());
        }

    }

    /**
     * @return
     */
    public static Timestamp yearStart() {
        return yearStart(new Date());
    }

    /**
     * @return
     */
    public static Timestamp yearEnd() {
        return yearEnd(new Date());
    }

    /**
     * @param timestamp
     * @param field
     * @param value
     * @return
     */
    public static Date add(Date timestamp, int field, int value) {
        synchronized (c) {
            c.setTimeInMillis(timestamp.getTime());
            c.add(field, value);
            return new Date(c.getTimeInMillis());
        }

    }

    /**
     * @param date
     * @param value n (y:years)(m:months)|(d:days)|(h:hours)|(mi:minutes)|(s:second)
     * @return
     */
    public static Date add(Date date, String value) {
        int n;
        String unit;
        try {
            n = Regexs.extractInteger(value, "");
            unit = value.replaceAll(String.valueOf(n), "");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("invalid format :" + value);
        }

        synchronized (c) {
            c.setTime(date);
            if (unit.toLowerCase().startsWith("y")) {
                c.add(Calendar.YEAR, n);
            } else if (unit.toLowerCase().startsWith("mi")) {
                c.add(Calendar.MINUTE, n);
            } else if (unit.toLowerCase().startsWith("m")) {
                c.add(Calendar.MONTH, n);
            } else if (unit.toLowerCase().startsWith("d")) {
                c.add(Calendar.DATE, n);
            } else if (unit.toLowerCase().startsWith("h")) {
                c.add(Calendar.HOUR, n);
            } else if (unit.toLowerCase().startsWith("s")) {
                c.add(Calendar.SECOND, n);
            }
            return new Timestamp(c.getTimeInMillis());
        }
    }

    /**
     * @param date
     * @param value n (y:years)(m:months)|(d:days)|(h:hours)|(mi:minutes)|(s:second)
     * @return
     */
    public static Date reduce(Date date, String value) {
        int n;
        String unit;
        try {
            n = Regexs.extractInteger(value, "");
            unit = value.replaceAll(String.valueOf(n), "");
            n = n * -1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("invalid format :" + value);
        }

        synchronized (c) {
            c.setTime(date);
            if (unit.toLowerCase().startsWith("y")) {
                c.add(Calendar.YEAR, n);
            } else if (unit.toLowerCase().startsWith("mi")) {
                c.add(Calendar.MINUTE, n);
            } else if (unit.toLowerCase().startsWith("m")) {
                c.add(Calendar.MONTH, n);
            } else if (unit.toLowerCase().startsWith("d")) {
                c.add(Calendar.DATE, n);
            } else if (unit.toLowerCase().startsWith("h")) {
                c.add(Calendar.HOUR, n);
            } else if (unit.toLowerCase().startsWith("s")) {
                c.add(Calendar.SECOND, n);
            }
            return new Timestamp(c.getTimeInMillis());
        }
    }


    /**
     * @param timestamp
     * @param field
     * @return
     */
    public static int get(Date timestamp, int field) {
        synchronized (c) {
            c.setTimeInMillis(timestamp.getTime());
            return c.get(field);
        }
    }

    /**
     * @param date
     * @return
     */
    public static int getMonthDays(Date date) {
        //1st of next month -1s
        int dayOffset = 0;
        synchronized (c) {
            c.setTime(date);
            //-----------------------------------
            c.add(Calendar.DAY_OF_YEAR, dayOffset);
            //-----------------------------------
            c.add(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c.add(Calendar.SECOND, -1);
            //------------------------------------

            return c.get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * @param serverTime
     * @param serverZT
     * @param clientZT
     * @return
     */
    public static long getClientTime(long serverTime, TimeZone serverZT, TimeZone clientZT) {
        return serverTime + clientZT.getRawOffset() - serverZT.getRawOffset();
    }

    /**
     * 1 - sunday
     * 2 - monday
     * ..
     *
     * @param date
     * @return
     */
    public static int getWeekDay(Date date) {
        synchronized (c) {
            c.setTime(date);
            return c.get(Calendar.DAY_OF_WEEK);
        }
    }

    /**
     * @param milliseconds
     * @return xx天xx小时xx分钟xx秒
     */
    public static String toTimeString(Long milliseconds) {
        if (milliseconds < 1000L) {
            return "0";
        }

        long day = milliseconds / (24 * 60 * 60 * 1000);
        long hour = (milliseconds / (60 * 60 * 1000) - day * 24);
        long min = ((milliseconds / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (milliseconds / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day);
            sb.append("天");
        }
        if (hour > 0 || (day > 0 && (min > 0 || s > 0))) {
            sb.append(hour);
            sb.append("小时");
        }
        if (min > 0 || ((day > 0 || hour > 0) && s > 0)) {
            sb.append(min);
            sb.append("分");
        }
        if (s > 0) {
            sb.append(s);
            sb.append("秒");
        }
        return sb.toString();
    }


    /**
     * 计算 second 秒后的时间
     *
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 计算两个日期间隔
     *
     * @param endDate
     * @param beginDate
     * @param model     模式："day"天，"hours"小时，"minute"分钟，"second"秒
     * @return 间隔时间
     */
    public static int intervalTime(Date endDate, Date beginDate, String model) {
        Long time = endDate.getTime() - beginDate.getTime();
        Long interval = 0L;
        switch (model) {
            case "day":
                interval = time / DAY_MILLI_SECOND;
                break;
            case "hours":
                interval = time / HOURS_MILLI_SECOND;
                break;
            case "minute":
                interval = time / MINUTES_MILLI_SECOND;
                break;
            case "second":
                interval = time / SECOND_MILLI_SECOND;
            default:
                break;
        }
        return interval.intValue();
    }

    /**
     * 计算两个日期间隔的时间字符串
     *
     * @param endDate
     * @param beginDate
     * @return String "1天12小时12分12秒"
     */
    public static String intervalStr(Date endDate, Date beginDate) {
        StringBuffer sb = new StringBuffer();
        Long time = endDate.getTime() - beginDate.getTime();

        long day = time / DAY_MILLI_SECOND;
        if (day > 0) {
            sb.append(day + "天");
        }

        time = time % DAY_MILLI_SECOND;
        long hours = time / HOURS_MILLI_SECOND;
        if (hours > 0) {
            sb.append(hours + "小时");
        }

        time = time % HOURS_MILLI_SECOND;
        long minutes = time / MINUTES_MILLI_SECOND;
        sb.append(minutes + "分");

        time = time % MINUTES_MILLI_SECOND;
        long second = time / SECOND_MILLI_SECOND;
        sb.append(second + "秒");

        return sb.toString();
    }

    /**
     * 计算两个日期间隔的时间字符串(12小时12分)
     *
     * @param endDate
     * @param beginDate
     * @return String "12小时12分"
     */
    public static String intervalHourMinuteStr(Date endDate, Date beginDate) {
        int nh = 60 * 60 * 1000;
        int nm = 60 * 1000;

        Long time = endDate.getTime() - beginDate.getTime();

        return intervalHourMinuteStr(time);
    }

    /**
     * 计算两个日期间隔的时间字符串(12小时12分)
     *
     * @return String "12小时12分"
     */
    public static String intervalHourMinuteStr(Long time) {
        int nh = 60 * 60 * 1000;
        int nm = 60 * 1000;

        String str = "";

        long hours = time / nh;
        if (hours != 0L) {
            str += hours + "小时";
        }
        time = time % nh;

        long minutes = time / nm;
        str += minutes + "分";

        return str;
    }


    /**
     * 计算两日期间隔的天数
     *
     * @param endDate   被减数
     * @param beginDate 减数
     * @return long
     */
    public static long dayInterval(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            return 0;
        }
        Calendar endCa = Calendar.getInstance();
        endCa.setTime(endDate);
        endCa.set(Calendar.HOUR_OF_DAY, 0);
        endCa.set(Calendar.MINUTE, 0);
        endCa.set(Calendar.SECOND, 0);
        endCa.set(Calendar.MILLISECOND, 0);

        Calendar beginCa = Calendar.getInstance();
        beginCa.setTime(beginDate);
        beginCa.set(Calendar.HOUR_OF_DAY, 0);
        beginCa.set(Calendar.MINUTE, 0);
        beginCa.set(Calendar.SECOND, 0);
        beginCa.set(Calendar.MILLISECOND, 0);

        Long millisecond = endCa.getTimeInMillis() - beginCa.getTimeInMillis();

        return millisecond / DAY_MILLI_SECOND;
    }

    /**
     * 获取"今天"，"明天"等字符串
     */
    public static String todayOrTomorrow(Date endDate, Date beginDate) {
        long day = dayInterval(endDate, beginDate);
        if (day == 0) {
            return "今天";
        } else if (day == 1) {
            return "明天";
        } else if (day == 2) {
            return "后天";
        }
        return "";
    }

    /**
     * 两个时间相差小时数
     *
     * @param endDate
     * @param beginDate
     * @param pattern
     * @param model     ceil：向上取整、floor：向下取整
     * @return
     */
    public static double hoursInterval(Date endDate, Date beginDate, String pattern, String model) {
        if (endDate == null || beginDate == null) {
            return 0;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = YYYY_MM_DD_HH_MM_SS;
        }

        endDate = parse(endDate, pattern);
        beginDate = parse(beginDate, pattern);

        double hours = 0.0;
        if ("ceil".equals(model)) { //向上取整
            hours = Math.ceil((double) (endDate.getTime() - beginDate.getTime()) / HOURS_MILLI_SECOND);
        } else if ("floor".equals(model)) { //向下取整
            hours = Math.floor((double) (endDate.getTime() - beginDate.getTime()) / HOURS_MILLI_SECOND);
        } else if ("halfAnHour".equals(model)) { //不满30分钟算30分钟
            double minute = Math.ceil((double) (endDate.getTime() - beginDate.getTime()) / MINUTES_MILLI_SECOND);
            double halfAnHours = Math.ceil((double) minute / 30);
            hours = halfAnHours / 2;
        } else {
            hours = (double) (endDate.getTime() - beginDate.getTime()) / HOURS_MILLI_SECOND;
        }
        return hours;
    }

    /**
     * 大于：比较第一个日期是否大于第二个日期
     *
     * @param endDate
     * @param beginDate
     * @param pattern
     * @return boolean
     */
    public static boolean endGrBegin(Date endDate, Date beginDate, String pattern) {
        if (endDate == null || beginDate == null) {
            return false;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = YYYY_MM_DD_HH_MM_SS;
        }

        endDate = parse(endDate, pattern);
        beginDate = parse(beginDate, pattern);

        return endDate.getTime() - beginDate.getTime() > 0 ? true : false;
    }

    /**
     * 大于等于：比较第一个日期是否大于等于第二个日期
     *
     * @param endDate
     * @param beginDate
     * @param pattern
     * @return boolean
     */
    public static boolean endGQBegin(Date endDate, Date beginDate, String pattern) {
        if (endDate == null || beginDate == null) {
            return false;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = YYYY_MM_DD_HH_MM_SS;
        }

        endDate = parse(endDate, pattern);
        beginDate = parse(beginDate, pattern);

        return endDate.getTime() - beginDate.getTime() >= 0 ? true : false;
    }

    /**
     * 小于：比较第一个日期是否小于第二个日期
     *
     * @param endDate
     * @param beginDate
     * @param pattern
     * @return boolean
     */
    public static boolean endLeBegin(Date endDate, Date beginDate, String pattern) {
        if (endDate == null || beginDate == null) {
            return false;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = YYYY_MM_DD_HH_MM_SS;
        }

        endDate = parse(endDate, pattern);
        beginDate = parse(beginDate, pattern);

        return endDate.getTime() - beginDate.getTime() < 0 ? true : false;
    }

    /**
     * 小于等于：比较第一个日期是否小于等于第二个日期
     *
     * @param endDate
     * @param beginDate
     * @param pattern
     * @return boolean
     */
    public static boolean endLQBegin(Date endDate, Date beginDate, String pattern) {
        if (endDate == null || beginDate == null) {
            return false;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = YYYY_MM_DD_HH_MM_SS;
        }

        endDate = parse(endDate, pattern);
        beginDate = parse(beginDate, pattern);

        return endDate.getTime() - beginDate.getTime() <= 0 ? true : false;
    }

    /**
     * 等于：比较第一个日期是否等于第二个日期
     *
     * @param endDate
     * @param beginDate
     * @param pattern
     * @return boolean
     */
    public static boolean endEBegin(Date endDate, Date beginDate, String pattern) {
        if (endDate == null || beginDate == null) {
            return false;
        }

        if (StringUtils.isBlank(pattern)) {
            pattern = YYYY_MM_DD_HH_MM_SS;
        }

        endDate = parse(endDate, pattern);
        beginDate = parse(beginDate, pattern);

        return endDate.getTime() - beginDate.getTime() == 0 ? true : false;
    }

    /**
     * 根据当前周的星期几，获取日期
     *
     * @param weekly (1,2,3,4,5,6,7)
     * @return date
     */
    public static Calendar getDateByweek(int weekly) {
        Calendar now = Calendar.getInstance();
        //一周第一天是否为星期天
        boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = now.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }

        now.add(Calendar.DAY_OF_MONTH, weekly - weekDay);

        return now;
    }

    /**
     * 重新赋值日期的时分秒
     *
     * @param dateTo   被重新赋值的日期
     * @param dateFrom 新的时分秒
     * @return date
     */
    public static Date deassignHMS(Date dateTo, Date dateFrom) {
        Calendar dateToCa = Calendar.getInstance();
        dateToCa.setTime(dateTo);

        Calendar dateFromCa = Calendar.getInstance();
        dateFromCa.setTime(dateFrom);

        dateToCa.set(Calendar.HOUR_OF_DAY, dateFromCa.get(Calendar.HOUR_OF_DAY));
        dateToCa.set(Calendar.MINUTE, dateFromCa.get(Calendar.MINUTE));
        dateToCa.set(Calendar.SECOND, dateFromCa.get(Calendar.SECOND));

        return dateToCa.getTime();
    }

    public static LocalDate str2Date (String str)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Dates.YYYY_MM_DD);
        return LocalDate.parse(str,formatter);
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static LocalDate str2LocalDate (String str)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Dates.YYYY_MM_DD);
        return LocalDate.parse(str,formatter);
    }

    public static String localDatetoStr (LocalDate date)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Dates.YYYY_MM_DD);
        return date.format(formatter);
    }

}
