package com.file.easyexcel;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.TimeConsumingUtils;
import com.alibaba.excel.EasyExcel;

import java.util.*;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo01 {
    public static void main(String[] args) {
        TimeConsumingUtils timeConsumingUtils = new TimeConsumingUtils();
        String filename = "D:\\user1q1.xlsx";

        // 向Excel中写入数据 也可以通过 head(Class<?>) 指定数据模板
        EasyExcel.write(filename, User.class)
                .sheet("用户信息")
                .doWrite(getUserData());

        timeConsumingUtils.printDateDiff(null,"asdfafa");
    }

    // 根据user模板构建数据
    private static List<User> getUserData() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
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
