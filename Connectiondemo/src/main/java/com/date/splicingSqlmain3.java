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
        String fieldsSql = "'”ÂABN6982','”ÂB237LW','”ÂDDD371','”ÂBF545L','”ÂAP576R','”ÂAHX450','”ÂAD59926','”ÂBR2086','”ÂCKA567','”ÂBT648Z','”ÂAAF9832','”ÂADE5336','”ÂAFP9259','”ÂABK6019','”ÂAUA452','”ÂAAA4652','”ÂA952D3','”ÂABQ9568'";
        AtomicReference<String> rowStr= new AtomicReference<>("");
        Arrays.stream(fieldsSql.split(",")).forEach(row->{
//            row = row.substring(1, row.length()-1);
            if(!rowStr.get().contains(row)){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2025-07-01 00:00:00', 0, 1, '2035-07-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª5¬º»Î20250703', %s, '19163154356', '∫´æ≤', 2);"
                        ,row,row.length()==10?4:0));

            }
        });
//        System.out.println(rowStr.get());


    }
}
