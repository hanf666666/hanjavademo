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
        String fieldsSql = "'”ÂA57N3E','”ÂB07Y57','”ÂAT6L31','”ÂC7P902','”ÂABG7185','”ÂAG67131','”ÂAFP093','”ÂA016XY','”ÂAA66948','”ÂBQS322','”ÂB90B30','”ÂD3T113','”ÂGM7150','”ÂABP0011'";
        AtomicReference<String> rowStr= new AtomicReference<>("");
        Arrays.stream(fieldsSql.split(",")).forEach(row->{
//            row = row.substring(1, row.length()-1);
            if(!rowStr.get().contains(row)){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2025-05-01 00:00:00', 0, 1, '2035-05-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª¬º»Î20250606', %s, '19163154356', '∫´æ≤', 2);"
                        ,row,row.length()==10?4:0));

            }
        });
//        System.out.println(rowStr.get());


    }
}
