package com.file.hutoolexcel;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.TimeConsumingUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo03 {
    public static void main(String[] args) {
//        CsvReader reader = CsvUtil.getReader();
//        communicationsBankReconciliationDTOList = reader.read(ResourceUtil.getReader(response.getFilePath() + response.getFileName(), CharsetUtil.CHARSET_GBK), CommunicationsBankReconciliationDTO.class);
        ExcelReader reader = ExcelUtil.getReader("aaaa.xlsx",1);
//        List<List<Object>> read = reader.read();
        List<List<Object>> read = reader.read(1,128);
//        List<PlateDTO> read = reader.read(0,128,PlateDTO.class);
//        List<PlateDTO> read = reader.readAll(PlateDTO.class);
//        List<PlateDTO> read = reader..readAll(PlateDTO.class);
//        List<List<Object>> read = reader.readAll();
        for (int i = 0; i < read.size(); i++) {
            List<Object> row=read.get(i);
//            System.out.println(row);
//            int id=i+812;
            int id=i+1000;
            String[] platesplit = row.get(2).toString().split("、");
            String startTime = row.get(3).toString();
            String endTIme = row.get(4).toString();
//            System.out.println(startTime);
//            System.out.println(endTIme);
            String longrentCar = String.format("INSERT INTO meisoodev.roadside_longrent_car\n" +
                            "(id, user_name, phone, start_time, end_time, truck_space, payable, status, rule_Id, combo_id, deleted, created_time, update_time, created_by, extend)\n" +
                            "VALUES("+id+", '%s', '17130956931', '%s', '%s', 1, 10000, 1, 141, 705, 0, now(), now(), 'hjhjhj', NULL);"
                    ,row.get(2).toString(),startTime,endTIme);
            System.out.println(longrentCar);

            for (int j = 0; j < platesplit.length; j++) {
                int length = platesplit[j].length();
                String plate_no_rel_parksql= String.format("INSERT INTO meisoodev.roadside_longrent_car_plate_no_rel_park\n" +
                                "( long_car_id, phone, plate_no, park_id, park_name, colour)\n" +
                                "VALUES( "+id+", '17130956931', '%s', 126556, '久桓城一期',%s);",
                        platesplit[j], length==7?0:4
                );
                System.out.println(plate_no_rel_parksql);

                String plate_no_rel_parksql2= String.format("INSERT INTO meisoodev.roadside_longrent_car_plate_no_rel_park\n" +
                                "( long_car_id, phone, plate_no, park_id, park_name, colour)\n" +
                                "VALUES( "+id+", '17130956931', '%s', 126556, '久桓城一期',%s);",
                        platesplit[j], length==7?0:4
                );
                System.out.println(plate_no_rel_parksql2);


            }


        }

    }
}
