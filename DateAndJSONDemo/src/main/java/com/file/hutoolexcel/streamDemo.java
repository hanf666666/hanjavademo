package com.file.hutoolexcel;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.TimeConsumingUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class streamDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TimeConsumingUtils timeConsumingUtils = new TimeConsumingUtils();
        // ͨ�������ഴ��writer
        BigExcelWriter writer = ExcelUtil.getBigWriter("d:/writeMapTest"+new Random().nextInt(1000) +".xlsx");
//        ExcelWriter writer = ExcelUtil.getBigWriter("d:/writeMapTest"+new Random().nextInt(1000) +".xlsx");
        ArrayList<Map<String, Object>> rows = new ArrayList<>();
        for (int i = 0; i <100000; i++) {

            for (int j = 0; j < 10; j++) {
                Map<String, Object> row1 = new LinkedHashMap<>();
                for (int k = 0; k < 1 ; k++) {
                    row1.put("����"+k, "����");
                    row1.put("����"+k, 23);
                    row1.put("�ɼ�"+k, 88.32);
                    row1.put("�Ƿ�ϸ�"+k, true);
                    row1.put("��������"+k, DateUtil.date());
                }
                rows.add(row1);

            }
//            writer.write(rows,  i==0);
//            rows.clear();
        }

        writer.write(rows,  true);
        rows.clear();

// �ϲ���Ԫ���ı����У�ʹ��Ĭ�ϱ�����ʽ
//        writer.merge(row1.size() - 1, "һ��ɼ���");
// һ����д�����ݣ�ʹ��Ĭ����ʽ��ǿ���������

// �ر�writer���ͷ��ڴ�
        writer.close();
        timeConsumingUtils.printDateDiff(null,"asdfafa");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
