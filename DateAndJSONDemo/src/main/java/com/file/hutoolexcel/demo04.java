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

        //原始 数据
        List<Map<String, Object>> oldMap1 = ExcelUtil.getReader(fileName, 0).readAll();
        //新数据
        List<Map<String, Object>> newMap2 = ExcelUtil.getReader(fileName, 1).readAll();
        HashMap<String, String> newRowHashMap = new HashMap<>();
        newMap2.forEach(newRowMap -> {
//            System.out.println(map.get("车牌号").toString());
//            System.out.println(map.get("车牌颜色").toString());
//            System.out.println(map.get("车主电话").toString());
//            System.out.println(map.get("欠费金额(元)").toString());
//            System.out.println( map);
            if(newRowMap.get("车牌号")==null){
                return;
            }
            String s = newRowMap.get("车牌号").toString().replaceAll("-", "") + newRowMap.get("车牌颜色").toString();
//            String s = newRowMap.get("车牌号").toString().replaceAll("-", "") ;

//            System.out.println( s);
//            stringStringHashMap.put(s,map.get("欠费金额(元)").toString()+map.get("欠费金额(元)").toString());
            newRowHashMap.put(s,newRowMap.get("车牌号").toString() + "\t" + newRowMap.get("车牌颜色").toString() + "\t" + newRowMap.get("欠费金额(元)").toString());
        });
        oldMap1.forEach(oldRowMap -> {
//            System.out.println(map);
//            System.out.println(oldRowMap.get("车牌号").toString());
//            System.out.println(oldRowMap.get("车牌颜色").toString());
//            System.out.println(oldRowMap.get("车主电话").toString());
//            System.out.println(oldRowMap.get("欠费金额(元)").toString());
//            String s = map.get("车牌号").toString().replaceAll("-", "") + map.get("车牌颜色").toString();
//            String s = oldRowMap.get("车牌号").toString().replaceAll("-", "") ;
            String s = oldRowMap.get("车牌号").toString().replaceAll("-", "") + oldRowMap.get("车牌颜色").toString();

            System.out.println( oldRowMap.get("车牌号").toString() + "\t" + oldRowMap.get("车主电话").toString() + "\t" + oldRowMap.get("欠费金额(元)").toString() + "\t" + newRowHashMap.get( s));
//            System.out.println( oldRowMap.get("车牌号").toString() + "\t" + oldRowMap.get("车主电话").toString() + "\t" + stringStringHashMap.get( s));

        });


    }
}
