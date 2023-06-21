package com.assert1.hutool;


import cn.hutool.core.lang.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 * true就能走正常流程 false就会报错
 * @author Hj
 * @date 2023/4/1
 */
public class demo {
    public static void main(String[] args) {
        Map map=new HashMap<String,String>();
//        Assert.notNull((String) map.get("teamId"),"班组teamId不能为空1");
//        Assert.notNull(null,"班组teamId不能为空1");
//        Assert.isNull("null","这个值必定空,否则报错");
//        Assert.isNull("null2","这个值必定空,否则报错");
        Assert.isTrue("null2".equals("null"),"这个值必定空,否则报错");





    }
}
