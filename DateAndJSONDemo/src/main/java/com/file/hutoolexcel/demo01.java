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
                row1.put("����"+j, "����");
                row1.put("����"+j, 23);
                row1.put("�ɼ�"+j, 88.32);
                row1.put("�Ƿ�ϸ�"+j, true);
                row1.put("��������"+j, DateUtil.date());

            }
            rows.add(row1);

        }


        // ͨ�������ഴ��writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeMapTest1.xlsx");
// �ϲ���Ԫ���ı����У�ʹ��Ĭ�ϱ�����ʽ
//        writer.merge(row1.size() - 1, "һ��ɼ���");
// һ����д�����ݣ�ʹ��Ĭ����ʽ��ǿ���������
        writer.write(rows, true);
// �ر�writer���ͷ��ڴ�
        writer.close();
        timeConsumingUtils.printDateDiff(null,"asdfafa");
    }
}
