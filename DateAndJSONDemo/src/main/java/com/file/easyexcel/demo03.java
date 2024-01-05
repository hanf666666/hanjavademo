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
     * �ظ����д��
     * <p>
     * 1. ����excel��Ӧ��ʵ����� ����{@link }
     * <p>
     * 2. ʹ��{@link }ע��ָ�����ӵ�ͷ
     * <p>
     * 3. ֱ�ӵ��ö���д�뼴��
     */

    public static void repeatedWrite() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // ����1: ���д��ͬһ��sheet
        String fileName = "D:\\user1q1" + new Random().nextInt(1000) + ".xlsx";

        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        // ����ע�� ���ͬһ��sheetֻҪ����һ��
        WriteSheet writeSheet = EasyExcel.writerSheet("ģ��").build();
        // ȥ����д��,�����ҵ�������Σ�ʵ��ʹ��ʱ�������ݿ��ҳ���ܵ�ҳ����
        for (int i = 0; i < 100000; i++) {
            // ��ҳȥ���ݿ��ѯ���� �������ȥ���ݿ��ѯÿһҳ������
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
                    .gender(i % 2 == 0 ? "��" : "Ů")
                    .salary(i * 1000.00)
                    .hireDate(new Date())
                    .build();
            users.add(user);
        }
        return users;
    }

}
