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
        String fieldsSql = "'”ÂDDZ286','”ÂAT1J56','”ÂCT3129','”ÂA73Z8B','”ÂA1G221','¥®KED563','”ÂB737EF','”ÂBP2756','”ÂAX7D05','”ÂAAT6148', '”ÂA20NJ5','”ÂBG7185', '”ÂAD43305','”ÂAAA7823','”ÂABL3558','”ÂBEC950','”ÂABJ2389','”ÂBK6361', '”ÂA8BS36','”ÂAVM344','”ÂA993KC','”ÂG3H169','”ÂD9N109','”ÂAAX7930','”ÂA7CH90','”ÂA528JP','”ÂAGE8678','”ÂA09P95'";
        AtomicReference<String> rowStr= new AtomicReference<>("");
        Arrays.stream(fieldsSql.split(",")).forEach(row->{
//            row = row.substring(1, row.length()-1);
            if(!rowStr.get().contains(row)){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2025-04-01 00:00:00', 0, 1, '2035-04-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª¬º»Î20250506', %s, '19163154356', '∫´æ≤', 2);"
                        ,row,row.length()==10?4:0));

            }
        });
//        System.out.println(rowStr.get());


    }
}
