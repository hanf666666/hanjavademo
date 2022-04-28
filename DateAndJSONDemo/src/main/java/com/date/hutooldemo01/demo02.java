package com.date.hutooldemo01;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;

/**
 * to do
 *  �㹤����
 * @author Hj
 * @date 2022/1/13
 */
public class demo02 {
    public static void main(String[] args) {

        for (int month = 1; month <13 ; month++) {
            System.out.println(month+"�·�"+countWorkDay(2022, month));
        }

    }

    /**
     * ��ȡָ�������ж��ٸ������գ�
     *
     * @param year
     * @param month
     * @return
     */
    public static int countWorkDay(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        // �·��Ǵ�0��ʼ���㣬������Ҫ��1
        c.set(Calendar.MONTH, month - 1);

        // �������һ�������
        int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        // ��ʼ����Ϊ1��
        int start = 1;
        // ����
        int count = 0;
        while (start <= max) {
            c.set(Calendar.DAY_OF_MONTH, start);
            if (isWorkDay(c)) {
                count++;
            }
            start++;
        }
        return count;
    }

    // �ж��Ƿ����գ�δ�ų������ڼ��գ������漰��ũ�����գ�������鷳��
    public static boolean isWorkDay(Calendar c) {
        // ��ȡ����,1~7,����1���������գ�2��������һ ... 7����������
        int week = c.get(Calendar.DAY_OF_WEEK);
        // �������������յĶ���Ϊ�ǹ�����
        return week != Calendar.SUNDAY && week != Calendar.SATURDAY;
    }

}
