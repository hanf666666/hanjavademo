package com.file.hutoolexcel;

import cn.hutool.poi.excel.ExcelUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hj
 * @date 2026/1/15
 */
public class zhujiaodemo {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Administrator\\Desktop\\meisoocity\\zhujiao.xls";
        List<Map<String, Object>> maps1 = ExcelUtil.getReader(fileName, 0).readAll();
        System.out.println("            \"SELECT '040220251220000105000598913Y' AS channel_order, '2512200001049109178' AS no, '丰都阳光上海城' AS name, 187396 AS id, 2 AS type, '甘AFA6631' AS plate_no, 1100 AS money_pay, '重庆' AS cityName, '丰都县' AS areaName\\n\"\n");
        maps1.forEach(map -> {
            //channel_order	no	name	id	type	plate_no	money_pay	cityName	areaName

            String sql = String.format("UNION ALL SELECT '%s','%s','%s','%s','%s','%s','%s','%s','%s'",
                    map.get("channel_order").toString(),
                    map.get("no").toString(),
                    map.get("name").toString(),
                    map.get("id").toString(),
                    map.get("type").toString(),
                    map.get("plate_no").toString(),
                    map.get("money_pay").toString(),
                    map.get("cityName").toString(),
                    map.get("areaName").toString());
            System.out.println(sql);
        });


    }

}
