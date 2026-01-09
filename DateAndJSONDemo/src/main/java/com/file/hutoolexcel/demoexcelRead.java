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
//        String fileName = "E:\\资料\\盘古美天科技\\20220914中台\\20230423对外开发平台\\2024061901遂宁街道信息维护\\遂宁市.xlsx";
        String fileName = "C:\\Users\\Administrator\\Desktop\\meisoocity\\suining.xlsx";
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
