package com.file.hutoolexcel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/7
 */
public class demoExcelToSql {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\han\\Desktop\\meisoocity\\ExceltoSQl.xlsx";
        ExcelReader reader = ExcelUtil.getReader(fileName, 2);
        List<Map<String, Object>> maps = reader.readAll();
        maps.forEach(map -> {
//            insertdemo(map);
            update_mt_to_cq_base_park2(map);
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
