package com.assert1.hutool;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 * true�������������� false�ͻᱨ��
 * @author Hj
 * @date 2023/4/1
 */
public class demo {
    public static void main(String[] args) {

        StringBuilder sql = new StringBuilder();

        sql.append(" LEFT JOIN (select mobile_app_user_id,plate_no,plate_no_colour from mobile_app_user_vehicle v final prewhere v._sign=1 and v.deleted=0 ) muv final on t.plate_no = muv.plate_no and t.plate_no_color = muv.plate_no_colour ");
        sql.append(" LEFT JOIN (select id,phone from mobile_app_user u final prewhere u._sign=1) mu final on muv.mobile_app_user_id = mu.id ");
        sql.append(" from ").append("( ").append("arrearsSql").append(" ) t ");
        System.out.println(sql.toString());

        long l = DateUtil.between(DateUtil.parseDateTime("2023-09-20 00:00:00"),
                DateUtil.parseDateTime("2023-10-19 00:00:00"), DateUnit.DAY);
        System.out.println(l);
        System.out.println(l>31);


        Map map=new HashMap<String,String>();
//        Assert.notNull((String) map.get("teamId"),"����teamId����Ϊ��1");
        Assert.notNull(null,"����teamId����Ϊ��1");
//        Assert.isNull("null","���ֵ�ض���,���򱨴�");
//        Assert.isNull("null2","���ֵ�ض���,���򱨴�");
//        Assert.isTrue("null2".equals("null"),"���ֵ�ض���,���򱨴�");
        Assert.isFalse(false,"���ֵ�ض���,���򱨴�");
        Assert.isFalse(true,"���ֵ�ض���,���򱨴�");






    }
}
