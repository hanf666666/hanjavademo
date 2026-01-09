package com.file.hutoolexcel;


import cn.hutool.poi.excel.ExcelUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车牌匹配
 *
 * @author Hj
 * @date 2024/7/7
 */
public class uft8demo {
    //车牌号	车牌颜色	车主电话	欠费金额(元)
    //车牌号	车牌颜色	车主电话	欠费金额(元)
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Administrator\\Desktop\\meisoocity\\aaaa.xls";
        List<Map<String, Object>> maps1 = ExcelUtil.getReader(fileName, 0).readAll();
        List<Map<String, Object>> maps2 = ExcelUtil.getReader(fileName, 1).readAll();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        maps2.forEach(map -> {
//            System.out.println( map);
            if(map.get("车牌号")==null){
                return;
            }
            String s = map.get("车牌号").toString().replaceAll("-", "") + map.get("颜色").toString();
//            System.out.println( s);
            stringStringHashMap.put(s,map.get("欠费金额(元)").toString());
        });
        maps1.forEach(map -> {
            String s = map.get("车牌号").toString().replaceAll("-", "") + map.get("车牌颜色").toString();

            System.out.println( map.get("车牌号").toString() + "\t" + map.get("车牌颜色").toString() + "\t" + map.get("车主电话").toString() + "\t" + map.get("欠费金额(元)").toString() + "\t" + stringStringHashMap.get( s));

        });


    }

    private static void update_mt_to_cq_base_park(Map<String, Object> map) {
//        System.out.println(map);
        System.out.println(String.format("update  mt_to_cq_base_park " +
                        "set vendor_park_name='%s'," +
                        "total_space='%s', " +
                        "address='%s', " +
                        "street_name='%s' " +
                        "where vendor_park_name='%s';",
                map.get("合并车场名称"),
                map.get("泊位数"),
                map.get("车场地址"),
                map.get("街道"),
                map.get("车场名称")
        ));
    }
    private static void update_mt_to_cq_base_park2(Map<String, Object> map) {
//        System.out.println(map);
        System.out.println(String.format("update  mt_to_cq_base_park " +
                        "set vendor_park_name='%s'," +
                        "total_space='%s', " +
                        "address='%s', " +
                        "street_name='%s' " +
                        "where vendor_park_name='%s';",
                map.get("合并车场名称"),
                map.get("泊位数"),
                map.get("车场地址"),
                map.get("街道"),
                map.get("车场名称")
        ));
    }


    private static void insertdemo(Map<String, Object> map) {
        System.out.println();
    }
}
