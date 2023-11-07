package com.file.hutoolexcel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/23
 */
public class demo04 {
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
        int count=0;

        for (int i = 0; i < read.size(); i++) {
            List<Object> row=read.get(i);
//            System.out.println(row);
//            int id=i+812;


            String[] platesplit = row.get(2).toString().split("、");
            String startTime = row.get(3).toString();
            String endTIme = row.get(4).toString();
//            System.out.println(startTime);
//            System.out.println(endTIme);


            for (int j = 0; j < platesplit.length; j++) {
                count=count+1;
                int id=count+8000;
                System.out.println("-- "+id);
                String plate = platesplit[j].replaceAll(" ", "");
                int length = plate.length();
                String user_white_list = String.format("INSERT INTO meisoodev.user_white_list\n" +
                                "(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name)\n" +
                                "VALUES("+id+", 1, '%s', 0, 1, '%s', '%s', NULL, %s, '19163154356', '丰都特殊处理');"
                        ,startTime,endTIme,plate,length==7?0:4);
                System.out.println(user_white_list);




                String user_white_list_park_info= String.format("INSERT INTO meisoodev.user_white_list_park_info\n" +
                                "(id, park_id, white_list_id, deleted, deleted_by, created_by, updated_by, deleted_dt, created_dt, updated_dt)\n" +
                                "VALUES(null, 126556, "+id+", 0, NULL, 10383, 10383, NULL,now(), now());"

                );
                System.out.println(user_white_list_park_info);

                String user_white_list_park_info2= String.format("INSERT INTO meisoodev.user_white_list_park_info\n" +
                        "(id, park_id, white_list_id, deleted, deleted_by, created_by, updated_by, deleted_dt, created_dt, updated_dt)\n" +
                        "VALUES(null, 128848, "+id+", 0, NULL, 10383, 10383, NULL,now(), now());"

                );
                System.out.println(user_white_list_park_info2);



            }


        }

    }
}
