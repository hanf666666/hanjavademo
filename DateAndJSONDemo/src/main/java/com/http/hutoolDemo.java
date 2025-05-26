package com.http;

import cn.hutool.Hutool;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/25
 */
public class hutoolDemo {
    public static void main(String[] args) {
//        HashMap<String, Object> paramMap = new HashMap<>();
        Map<String, Object> paramMap = new ConcurrentHashMap();
        String mm = DateUtil.date().offset(DateField.MONTH, -3).toString("MM");
        System.out.println(mm);
        paramMap.put("beginNum", "1");
        paramMap.put("endNum", "40");
        paramMap.put("beginDate", DateUtil.date().toString("yyyy-MM-01"));
        paramMap.put("endDate",  DateUtil.date().toString("yyyy-MM-28"));
        paramMap.put("hrmId", 1308);



        String result = HttpUtil.post("http://oa.dongyinghk.com:8000/custom/hrm/action/gethrmschedule.jsp", paramMap);
        System.out.println(result);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        List<OABean> result1 = BeanUtil.copyToList(jsonObject.getJSONArray("datas"), OABean.class);
        result1.forEach(row -> {
            System.out.println(row.getScheduledate()+" "+row.getBeginsigntime()+" "+row.getEndsigntime()+" "+row.getKqrequest());

        });


    }



}
