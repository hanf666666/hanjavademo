package com.file.easyexcel;

import com.TimeConsumingUtils;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;

import java.util.*;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo05 {
    public static void main(String[] args) {
        try {
            // 方法1 如果写到同一个sheet
            String fileName = "D:\\user1q1" + new Random().nextInt(1000) + ".xlsx";
            // 这里直接写多个table的案例了，如果只有一个 也可以直一行代码搞定，参照其他案例
            ExcelWriter excelWriter = null;
            try {
                // 这里不指定class
                excelWriter = EasyExcel.write(fileName).build();
                // 把sheet设置为不需要头 不然会输出sheet的头 这样看起来第一个table 就有2个头了
                WriteSheet writeSheet = EasyExcel.writerSheet("模板").needHead(Boolean.FALSE).build();
                // 这里必须指定需要头，table 会继承sheet的配置，sheet配置了不需要，table 默认也是不需要
                WriteTable writeTable0 = EasyExcel.writerTable(0).build();

                // 准备数据
                List<String> users = Arrays.asList("aaaaaaaa", "bbbbbbbb");
                List<List<String>> userRows = new ArrayList<>();
                for (String user : users) {
                    List<String> row = new ArrayList<>();
                    row.add(user);
                    userRows.add(row);
                }

//                // 准备表头（可选，根据需要添加或不加）
//                List<List<String>> header = new ArrayList<>();
//                List<String> headerRow = new ArrayList<>();
//                headerRow.add("用户名"); // 定义唯一的列名
//                header.add(headerRow);

                // 第一次写入会创建头
                excelWriter.write(userRows, writeSheet, writeTable0);
                // 第二个对象 读取对象的excel实体类中的标题
                WriteTable writeTable1 = EasyExcel.writerTable(1).head(User.class).needHead(Boolean.TRUE).build();

                // 第二次写如也会创建头，然后在第一次的后面写入数据
                excelWriter.write(getUserData1(), writeSheet, writeTable1);

            } finally {
                // 千万别忘记finish 会帮忙关闭流
                if (excelWriter != null) {
                    excelWriter.finish();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static List<String> getUserData() {
        List<String> users = new ArrayList<>();
        users.add("aaaaaaaaaaaaaaaa");
        users.add("aaaaaaaaaaaaaaaa");
        users.add("aaaaaaaaaaaaaaaa");
        users.add("aaaaaaaaaaaaaaaa");
        return users;
    }
    private static List<User> getUserData1() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            User user = User.builder()
                    .userId(i)
                    .userName("admin" + i)
                    .gender(i % 2 == 0 ? "男" : "女")
                    .salary(i * 1000.00)
                    .hireDate(new Date())
                    .build();
            users.add(user);
        }
        return users;
    }

}
