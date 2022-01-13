package com.json.hutooljson.strToBean2;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;

import java.time.LocalDateTime;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo01 {

    public static void main(String[] args) {

        String jsonStr="{\n" +
                "  \"name\": \"hanjing\",\n" +
                "  \"curDateTime\":1640966400000" +
                "}";
        final Student student = JSONUtil.toBean(jsonStr, Student.class,false);
        System.out.println(student);
        System.out.println(JSONUtil.parse(student));
//        System.out.println(DateUtil.parse("2022-01-01T00:00:00"));
        System.out.println(LocalDateTime.now());
        System.out.println("2022-01-13T18:24".length());



    }
}
