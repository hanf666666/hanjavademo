package com.json.hutooljson.bean;


import com.alibaba.fastjson.JSON;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/15
 */
public class Main2 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("1111111");
        Student2 student2 = new Student2();
        student2.setStudent(student);
        student2.setName2("22222222");
        student.setStudent2(student2);

        String str = JSON.toJSONString(student);
        System.out.println(str);
    }
}
