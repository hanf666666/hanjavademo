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
        String fieldsSql = "'��ABN6982','��B237LW','��DDD371','��BF545L','��AP576R','��AHX450','��AD59926','��BR2086','��CKA567','��BT648Z','��AAF9832','��ADE5336','��AFP9259','��ABK6019','��AUA452','��AAA4652','��A952D3','��ABQ9568'";
        AtomicReference<String> rowStr= new AtomicReference<>("");
        Arrays.stream(fieldsSql.split(",")).forEach(row->{
//            row = row.substring(1, row.length()-1);
            if(!rowStr.get().contains(row)){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2025-07-01 00:00:00', 0, 1, '2035-07-01 00:00:00', %s, '�м���ͳһ5¼��20250703', %s, '19163154356', '����', 2);"
                        ,row,row.length()==10?4:0));

            }
        });
//        System.out.println(rowStr.get());


    }
}
