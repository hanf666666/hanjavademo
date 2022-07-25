package com.file.easyexcel;

import com.TimeConsumingUtils;
import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo02 {
    public static void main(String[] args) {
        TimeConsumingUtils timeConsumingUtils = new TimeConsumingUtils();
        String filename = "D:\\user1q1.xlsx";

        // ��Excel��д������ Ҳ����ͨ�� head(Class<?>) ָ������ģ��
        EasyExcel.write(filename, User.class)
                .sheet("�û���Ϣ")
                .doWrite(getUserData());

        timeConsumingUtils.printDateDiff(null,"asdfafa");
    }

    // ����userģ�幹������
    private static List<User> getUserData() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
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
