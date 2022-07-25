package com.file.hutoolexcel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.TimeConsumingUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo01 {
    public static void main(String[] args) {
        TimeConsumingUtils timeConsumingUtils = new TimeConsumingUtils();

        ArrayList<Map<String, Object>> rows = new ArrayList<>(12011);
        for (int i = 0; i <12011; i++) {
            Map<String, Object> row1 = new LinkedHashMap<>(100);
            for (int j = 0; j < 20; j++) {
                row1.put("姓名"+j, "张三");
                row1.put("年龄"+j, 23);
                row1.put("成绩"+j, 88.32);
                row1.put("是否合格"+j, true);
                row1.put("考试日期"+j, DateUtil.date());

            }
            rows.add(row1);

        }


        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeMapTest1.xlsx");
// 合并单元格后的标题行，使用默认标题样式
//        writer.merge(row1.size() - 1, "一班成绩单");
// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
// 关闭writer，释放内存
        writer.close();
        timeConsumingUtils.printDateDiff(null,"asdfafa");
    }
}
