package com.json.hutooljson.strToBean;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo01 {

    public static void main(String[] args) {

//        String jsonStr="{\n" +
//                "  \"name\": \"hanjing\",\n" +
//                "  \"curDateTime\": \"2022-01-01T00:00:00.000\"\n" +
//                "}";
        // DateUtil.parse(value)
        String jsonStr="{\n" +
                "  \"name\": \"hanjing\",\n" +
                "  \"curDateTime\": \"2022-01-01T00:00\"\n" +
                "}";
//        final Student student = JSONUtil.toBean(jsonStr, Student.class,false);
//        System.out.println(JSONUtil.parse(student));
        System.out.println(DateUtil.parse("2022-01-01T00:00:00"));


        Student student=null;
        System.out.println(student.toString());System.out.println(student.toString());

    }
}
