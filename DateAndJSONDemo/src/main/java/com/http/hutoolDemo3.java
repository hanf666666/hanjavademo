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
        paramMap.put("hrmId", 1378);


        String result = HttpUtil.post("http://oa.dongyinghk.com:8000/custom/hrm/action/gethrmschedule.jsp", paramMap);
        System.out.println(result);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        List<OABean> result1 = BeanUtil.copyToList(jsonObject.getJSONArray("datas"), OABean.class);
        List<Object> list = new ArrayList<>();
        result1.forEach(row -> {
//            System.out.println(row);
            String startDate = null;
            if (row.getScheduletype().contains("节假日")||row.getScheduletype().contains("公休日")) {
                startDate = row.getScheduledate() + " " + row.getBeginsigntime();
            } else {
                if(row.getBeginsigntime().contains("---") ||row.getBeginsigntime().compareTo("12:00")>0  ) {
                    list.add(row);
                }
                //工作日
                startDate = row.getScheduledate() + " 19:00";
            }
            if (!row.getEndsigntime().contains("---")&&!row.getEndsigntime().contains("18:")&&!row.getEndsigntime().contains("08:")) {
                String endDate = row.getScheduledate() + " " + row.getEndsigntime();
                if (startDate.compareTo(endDate) > 0) {
                    endDate = DateUtil.parse(endDate, "yyyy-MM-dd HH:mm").offset(DateField.DAY_OF_YEAR, 1).toString();
                }
                Double timeDiff = timeDiffCalculator(startDate, endDate);
                System.out.println(row.getScheduletype()+ "\t"+row.getScheduledate() + "\t" + row.getBeginsigntime() + "\t" + row.getEndsigntime() + "\t" + timeDiff+ "\t" + row.getKqrequest() );

            }
        });
        System.out.println("======================");
        list.forEach(System.out::println);

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
