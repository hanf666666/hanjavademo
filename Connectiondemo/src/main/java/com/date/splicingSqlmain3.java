package com.date;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain3 {
    public static void main(String[] args) {
        String fieldsSql = "'��DDZ286','��AT1J56','��CT3129','��A73Z8B','��A1G221','��KED563','��B737EF','��BP2756','��AX7D05','��AAT6148', '��A20NJ5','��BG7185', '��AD43305','��AAA7823','��ABL3558','��BEC950','��ABJ2389','��BK6361', '��A8BS36','��AVM344','��A993KC','��G3H169','��D9N109','��AAX7930','��A7CH90','��A528JP','��AGE8678','��A09P95'";
        AtomicReference<String> rowStr= new AtomicReference<>("");
        Arrays.stream(fieldsSql.split(",")).forEach(row->{
//            row = row.substring(1, row.length()-1);
            if(!rowStr.get().contains(row)){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2025-04-01 00:00:00', 0, 1, '2035-04-01 00:00:00', %s, '�м���ͳһ¼��20250506', %s, '19163154356', '����', 2);"
                        ,row,row.length()==10?4:0));

            }
        });
//        System.out.println(rowStr.get());


    }
}
