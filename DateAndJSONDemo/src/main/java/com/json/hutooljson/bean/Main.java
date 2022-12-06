package com.json.hutooljson.bean;

import cn.hutool.core.lang.Pair;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/15
 */
public class Main {
    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("1111111");
//        Student2 student2 = new Student2();
//        student2.setStudent(student);
//        student2.setName2("22222222");
//        student.setStudent2(student2);
//
//
//        JSON parse = JSONUtil.parse(student);
//        System.out.println(parse);


        Pair<Boolean, Student> of = Pair.of(false, null);


        System.out.println( of.getKey());
        System.out.println(of.getValue());

    }
}
