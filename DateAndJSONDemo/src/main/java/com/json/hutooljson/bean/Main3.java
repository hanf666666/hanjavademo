package com.json.hutooljson.bean;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/15
 */
public class Main3 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("1111111");
        Result<Student> studentResult = Result.success(111, "���ش���", student);
        String str = JSON.toJSONString(studentResult);
        System.out.println("str===="+str);
        //Ҫ��JSONUtil��Ҫ��BeanUtil �޷�����
//        Result bean = BeanUtil.toBean(str, new Result<Student>().getClass());
        Result bean = JSONUtil.toBean(str, new Result<Student>().getClass());
        System.out.println("bean===="+bean);
    }
}
