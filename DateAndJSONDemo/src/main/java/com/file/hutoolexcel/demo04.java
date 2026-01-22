package com.file.hutoolexcel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo04 {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Administrator\\Desktop\\meisoocity\\aaaa.xls";
        List<Map<String, Object>> maps1 = ExcelUtil.getReader(fileName, 0).readAll();
        List<Map<String, Object>> maps2 = ExcelUtil.getReader(fileName, 1).readAll();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        maps2.forEach(map -> {
//            System.out.println(map.get("车牌号").toString());
//            System.out.println(map.get("车牌颜色").toString());
//            System.out.println(map.get("车主电话").toString());
//            System.out.println(map.get("欠费金额(元)").toString());
//            System.out.println( map);
            if(map.get("车牌号")==null){
                return;
            }
//            String s = map.get("车牌号").toString().replaceAll("-", "") + map.get("车牌颜色").toString();
            String s = map.get("车牌号").toString().replaceAll("-", "") ;

//            System.out.println( s);
//            stringStringHashMap.put(s,map.get("欠费金额(元)").toString()+map.get("欠费金额(元)").toString());
            stringStringHashMap.put(s,map.get("车牌号").toString() + "\t" + map.get("车牌颜色").toString() + "\t" + map.get("车主电话").toString() + "\t" + map.get("欠费金额(元)").toString());
        });
        maps1.forEach(map -> {
//            System.out.println(map);
//            System.out.println(map.get("车牌号").toString());
//            System.out.println(map.get("车牌颜色").toString());
//            System.out.println(map.get("车主电话").toString());
//            System.out.println(map.get("欠费金额(元)").toString());
//            String s = map.get("车牌号").toString().replaceAll("-", "") + map.get("车牌颜色").toString();
            String s = map.get("车牌号").toString().replaceAll("-", "") ;

//            System.out.println( map.get("车牌号").toString() + "\t" + map.get("车牌颜色").toString() + "\t" + map.get("车主电话").toString() + "\t" + map.get("欠费金额(元)").toString() + "\t" + stringStringHashMap.get( s));
            System.out.println( map.get("车牌号").toString() + "\t" + map.get("车主电话").toString() + "\t" + stringStringHashMap.get( s));

        });


    }
}
