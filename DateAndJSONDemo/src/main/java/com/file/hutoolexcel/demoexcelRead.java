package com.file.hutoolexcel;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/19
 */
public class demoexcelRead {
    public static void main(String[] args) {
//        String fileName = "E:\\����\\�̹�����Ƽ�\\20220914��̨\\20230423���⿪��ƽ̨\\2024061901�����ֵ���Ϣά��\\������.xlsx";
        String fileName = "C:\\Users\\han\\Desktop\\meisoocity\\suining.xlsx";
        ExcelReader reader = ExcelUtil.getReader(fileName, 0);
//        List<Map<String, Object>> maps = reader.readAll();
//        maps.forEach(map -> {
//            StreetDTO streetDTO = BeanUtil.mapToBean(map, StreetDTO.class, true);
//            System.out.println("updatePark--->{}"+ JSONUtil.toJsonStr(map));
//            System.out.println("updatePark--->{}"+ streetDTO);
//        });

        List<StreetDTO> streetDTOS = reader.readAll(StreetDTO.class);
        System.out.println(streetDTOS);

    }
}
