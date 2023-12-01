package com.json.hutooljson.strToBean2;

import cn.hutool.json.JSONUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo02 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i <1000 ; i++) {
            Student student = new Student();
            student.setName("hanjing" + i);
            students.add(student);
        }
        students.forEach(student -> {
            System.out.println(student);
        });




    }
}
