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
public class hutoolDemojiaban {
    public static void main(String[] args) {
//        extracted();

        Map<String, Object> paramMap = new ConcurrentHashMap();
        String mm = DateUtil.date().offset(DateField.MONTH, -3).toString("MM");
        System.out.println(mm);
        paramMap.put("messageType", "");
        paramMap.put("chatsType", "");
        paramMap.put("uploadType", "");
        paramMap.put("selectfieldvalue", "");
        paramMap.put("workflowRequestLogId", "-1");
        paramMap.put("field13550", "");
        paramMap.put("requestlevel", "0");
        paramMap.put("requestname", "加班申请 - 韩静 - 2025 - 11 - 19");
        paramMap.put("field13551", "1378");
        paramMap.put("field13552", "213");
        paramMap.put("field13553", "20");
        paramMap.put("field13554", "2025-11-19");
        paramMap.put("field13555", "2025-11-04");
        paramMap.put("field13556", "19:00");
        paramMap.put("field13557", "2025-11-05");
        paramMap.put("field13558", "02:00");
        paramMap.put("field13582", "0.0");
        paramMap.put("field13703", "7.0");
        paramMap.put("field13564", "0");
        paramMap.put("oldfieldview13564", "3");
        paramMap.put("field14497", "0");
        paramMap.put("field13560", "1.渝畅停8车场数据推送, 涪陵");
        paramMap.put("remarkLocation", "");
        paramMap.put("remarkText10404	", "");
        paramMap.put("remark", "");
        paramMap.put("phraseselect", "");
        paramMap.put("workflowid", "1553");
        paramMap.put("workflowtype", "182");
        paramMap.put("nodeid", "13298");
        paramMap.put("nodetype", "0");
        paramMap.put("src", "submit");
        paramMap.put("iscreate", "1");
        paramMap.put("formid", "-467");
        paramMap.put("topage", "");
        paramMap.put("isbill", "1");
        paramMap.put("method", "");
        paramMap.put("needcheck", "field13555,field13556,field13557,field13558,field13564,field13582,field13560,field13703");
        paramMap.put("inputcheck", "");
        paramMap.put("isMultiDoc", "");
        paramMap.put("requestid", "-1");
        paramMap.put("rand", "1763519542181");
        paramMap.put("needoutprint", "");
        paramMap.put("htmlfieldids", "");
        paramMap.put("field13560", "加班原因;1,");
        paramMap.put("needwfback", "1");
        paramMap.put("f_weaver_belongto_userid", "");
        paramMap.put("f_weaver_belongto_usertype", "");
        paramMap.put("1378_1553_addrequest_submit_token", "1763519542182");
        paramMap.put("lastloginuserid", "1378");
        paramMap.put("freeNode", "0");
        paramMap.put("freeDuty", "1");


        String result = HttpUtil.post("http://oa.dongyinghk.com:8000/workflow/request/RequestOperation.jsp", paramMap);
        System.out.println(result);
        JSONObject jsonObject = JSONUtil.parseObj(result);
    }


}
