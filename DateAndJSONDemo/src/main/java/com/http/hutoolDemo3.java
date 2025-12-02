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
        String mm = DateUtil.date().offset(DateField.MONTH, -3).toString("MM");
        System.out.println(mm);
        paramMap.put("beginNum", "1");
        paramMap.put("endNum", "40");
        paramMap.put("beginDate", DateUtil.date().toString("yyyy-11-01"));
        paramMap.put("endDate", DateUtil.date().toString("yyyy-11-30"));
        paramMap.put("hrmId", 1308);

        String result=null;
         result = HttpUtil.post("http://oa.dongyinghk.com:8000/custom/hrm/action/gethrmschedule.jsp", paramMap);
//        result="{\"totalRecord\":\"30\",\"datas\":[{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-01\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"08:13\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"17:13\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151824\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-02\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"10:34\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"15:35\",\"endsigntimeflag\":\"0\",\"signcon\":\"4次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151825\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-03\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:59\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151826\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-04\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:59\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"02:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"6次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151827\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-05\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:19\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151827\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-06\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:57\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:30\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151832\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-07\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:20\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151832\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-08\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"08:56\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"18:26\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-09\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-10\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:59\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-19:151833\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-11\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:00\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:151999\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-12\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:27\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:01\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:151999\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-13\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"00:00\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152003,补卡申请-韩静-2025-11-25:152000\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-14\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:20\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:01\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152003\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-15\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"09:08\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"16:38\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152004\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-16\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-17\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:58\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152005\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-18\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"00:00\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152006,补卡申请-韩静-2025-11-25:152001\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-19\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"18:00\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152006\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-20\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:55\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:02\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152007\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-21\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:25\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:01\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152007\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-22\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"09:11\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"17:43\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152008\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-23\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-24\",\"scheduleweek\":\"星期一\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"22:00\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"1次\",\"kqrequest\":\"加班申请-韩静-2025-11-25:152010,补卡申请-韩静-2025-11-25:152002\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-25\",\"scheduleweek\":\"星期二\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:56\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"00:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"4次\",\"kqrequest\":\"加班申请-韩静-2025-11-28:152078\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-26\",\"scheduleweek\":\"星期三\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"09:17\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"3次\",\"kqrequest\":\"加班申请-韩静-2025-11-28:152078\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-27\",\"scheduleweek\":\"星期四\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:52\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"22:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"加班申请-韩静-2025-11-28:152079\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-28\",\"scheduleweek\":\"星期五\",\"scheduletype\":\"工作日\",\"timeslot\":\"08:30-12:00~14:00-18:00\",\"beginsigntime\":\"08:50\",\"beginsigntimeflag\":\"1\",\"endsigntime\":\"18:00\",\"endsigntimeflag\":\"0\",\"signcon\":\"2次\",\"kqrequest\":\"\",\"auditstatus\":\"异常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-29\",\"scheduleweek\":\"星期六\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"08:28\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"17:58\",\"endsigntimeflag\":\"0\",\"signcon\":\"5次\",\"kqrequest\":\"加班申请-韩静-2025-11-30:152182\",\"auditstatus\":\"正常\"},{\"subcompanyid\":\"20\",\"subcompanyname\":\"盘古美天\",\"departmentid\":\"213\",\"departmentname\":\"大数据部\",\"hrmid\":\"1378\",\"hrmname\":\"韩静\",\"scheduledate\":\"2025-11-30\",\"scheduleweek\":\"星期日\",\"scheduletype\":\"公休日\",\"timeslot\":\"---\",\"beginsigntime\":\"---\",\"beginsigntimeflag\":\"0\",\"endsigntime\":\"---\",\"endsigntimeflag\":\"0\",\"signcon\":\"0次\",\"kqrequest\":\"\",\"auditstatus\":\"正常\"}]}\n";
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
                System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t" + row.getBeginsigntime() + "\t" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );

            } else {
                if(row.getBeginsigntime().contains("---") ||row.getBeginsigntime().compareTo("12:00")>0 ||row.getBeginsigntime().compareTo("05:00")<0 ) {
                    errorlist.add(row);
                }
                //工作日
                startDate = row.getScheduledate() + " 19:00";
                if (!row.getEndsigntime().contains("---")&&!row.getEndsigntime().contains("08:")) {
                    String endDate = row.getScheduledate() + " " + row.getEndsigntime();
                    if ((row.getScheduledate()+" 05:00").compareTo(endDate) > 0&&!(row.getScheduletype().contains("节假日")||row.getScheduletype().contains("公休日"))) {
                        endDate = DateUtil.parse(endDate, "yyyy-MM-dd HH:mm").offset(DateField.DAY_OF_YEAR, 1).toString();
                    }
                    if(startDate.compareTo(endDate)>0){
                        return;
                    }
                    Double timeDiff = timeDiffCalculator(startDate, endDate);
                    System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t" + row.getBeginsigntime() + "\t" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );

                }
            }

        });
        System.out.println("======================");
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
