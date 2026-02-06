package com.http;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/25
 */
public class hutoolDemo3 {
    public static void main(String[] args) {
//        extracted();

        Map<String, Object> paramMap = new ConcurrentHashMap();
        int offset=0;
        String mm = DateUtil.date().offset(DateField.MONTH, offset).toString("MM");
        String nextmm = DateUtil.date().offset(DateField.MONTH, offset+1).toString("MM");
        System.out.println(mm);
        paramMap.put("beginNum", "1");
        paramMap.put("endNum", "40");
        paramMap.put("beginDate", DateUtil.date().toString("yyyy-"+mm+"-01"));
        paramMap.put("endDate", DateUtil.date().toString("yyyy-"+nextmm+"-01"));
        paramMap.put("hrmId", 1378);

        String result=null;
         result = HttpUtil.post("http://oa.dongyinghk.com:8000/custom/hrm/action/gethrmschedule.jsp", paramMap);
//        result="{\"totalRecord\":\"32\",\"datas\":[{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-01\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"节假日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-02\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"节假日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-03\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"节假日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-04\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"调配工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:55\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:28\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-05\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:57\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:27\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-06\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:58\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:30\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-07\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:54\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:24\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-08\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:51\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"加班申请-韩静-2026-01-09:153385\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-09\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:22\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:13\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-09:153385\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-10\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"09:26\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"11:56\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-12:153405\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-11\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-12\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:53\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:23\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-13\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:49\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:02\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"加班申请-韩静-2026-01-15:153547\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-14\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:25\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:21\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-15:153547\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-15\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:44\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:14\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-16\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:43\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:13\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-17\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-18\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-19\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"18:01\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:01\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"补卡申请-韩静-2026-01-22:153759\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-20\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"18:01\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:01\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"补卡申请-韩静-2026-01-22:153760\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-21\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:53\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:23\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-22\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:54\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-24:153796\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-23\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:54\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-24\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"11:04\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"17:37\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-26:153812\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-25\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-26\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:41\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:01\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-27:153868\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-27\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:47\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-29:153954\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-28\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"18:00\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-29\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:59\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:39\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-30\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:52\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:24\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-01-31\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"14:36\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"17:10\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2026-01-31:154041\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2026-02-01\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"}]}\n";
        System.out.println(result);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        List<OABean> result1 = BeanUtil.copyToList(jsonObject.getJSONArray("datas"), OABean.class);
        List<Object> errorlist = new ArrayList<>();
        result1.forEach(row -> {
//            System.out.println(row);
            String beginsigntime = row.getBeginsigntime();
            String scheduletype = row.getScheduletype();
            String scheduledate = row.getScheduledate();
//            if(!scheduledate.contains("2025-11-05")){
//                return;
//            }

            String startDate = null;
            if (row.getScheduletype().contains("节假日")||row.getScheduletype().contains("公休日")) {
                if(row.getBeginsigntime().contains("---")){
                    return;
                }
//                算早上时间
                startDate = row.getScheduledate() + " " + row.getBeginsigntime();
                String endDate = row.getScheduledate() + " " + row.getEndsigntime();
                Double timeDiff = timeDiffCalculator(startDate, endDate);
//                System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t" + row.getBeginsigntime() + "\t" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );
                System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t" + row.getBeginsigntime() + "-" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );

            } else {
                if(row.getBeginsigntime().contains("---") ||row.getBeginsigntime().compareTo("12:00")>0 ||row.getBeginsigntime().compareTo("05:00")<0 ) {
                    errorlist.add(row);
                }
                //工作日
                startDate = row.getScheduledate() + " 20:00";
                if (!row.getEndsigntime().contains("---")&&!row.getEndsigntime().contains("08:")) {
                    String endDate = row.getScheduledate() + " " + row.getEndsigntime();
                    if ((row.getScheduledate()+" 05:00").compareTo(endDate) > 0&&!(row.getScheduletype().contains("节假日")||row.getScheduletype().contains("公休日"))) {
                        endDate = DateUtil.parse(endDate, "yyyy-MM-dd HH:mm").offset(DateField.DAY_OF_YEAR, 1).toString();
                    }
                    if(startDate.compareTo(endDate)>0){
                        return;
                    }
                    Double timeDiff = timeDiffCalculator(startDate, endDate);
//                    System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t" + row.getBeginsigntime() + "\t" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );
                    System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t"  + "19:00-" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );

                }
            }

        });
        System.out.println("错误单子======================");
        errorlist.forEach(System.out::println);

    }


    public static Double timeDiffCalculator(String dateStr1, String dateStr2) {
        long betweenMinute = DateUtil.between(
                DateUtil.parse(dateStr1),
                DateUtil.parse(dateStr2),
                DateUnit.MINUTE
        );

        long absMinutes = Math.abs(betweenMinute);
        Double result = (absMinutes / 30) * 30 / 60.0; // 取整到30分钟的倍数
//        System.out.println("计算时长(分钟): " + result);
        return result;
    }


}
