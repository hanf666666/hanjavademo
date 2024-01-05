package com.file.easyexcel;

import com.TimeConsumingUtils;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo03 {
    public static void main(String[] args) {
        TimeConsumingUtils timeConsumingUtils = new TimeConsumingUtils();


        repeatedWrite();

        timeConsumingUtils.printDateDiff(null, "asdfafa");
    }

    /**
     * 重复多次写入
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link }
     * <p>
     * 2. 使用{@link }注解指定复杂的头
     * <p>
     * 3. 直接调用二次写入即可
     */

    public static void repeatedWrite() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 方法1: 如果写到同一个sheet
        String fileName = "D:\\user1q1" + new Random().nextInt(1000) + ".xlsx";

        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        // 这里注意 如果同一个sheet只要创建一次
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
        for (int i = 0; i < 100000; i++) {
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<User> data = getUserData();
            excelWriter.write(data, writeSheet);

        }
        excelWriter.finish();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private static List<User> getUserData() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
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
