package com.����Demo.��ʽ2;

import cn.hutool.core.bean.BeanUtil;

import java.util.HashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/5
 */
public class demo01 {
    public static void main(String[] args) {
        final HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        System.out.println("��");

        stringObjectHashMap.put("name", "hanjing");
        stringObjectHashMap.put("age", 22);
        stringObjectHashMap.put("utilDate", "2022/12/1");
        stringObjectHashMap.put("sqlDate", "2022/12/1");
        /**��ʽ1*/
//        final Son son = new Son();
//        son.setName("han");
//        son.setAge(1);
//        System.out.println(son);
        /**��ʽ2*/
        final HashMap<String, Object> sonHashMap = new HashMap<>();
        sonHashMap.put("name", "han");
        sonHashMap.put("age", 1);
        stringObjectHashMap.put("son", sonHashMap);
        /**ӳ��*/
        final Person person = BeanUtil.fillBeanWithMap(stringObjectHashMap, new Person(), false);
        System.out.println(person);

    }
}
