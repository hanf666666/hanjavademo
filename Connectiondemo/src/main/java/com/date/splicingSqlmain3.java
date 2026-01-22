package com.date;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ¬∑≤‡∞◊√˚µ•
 *
 * @author Hj
 * @date 2023/3/7
 */
public class splicingSqlmain3 {
    public static void main(String[] args) {
        String fieldsSql = "'”ÂA023SZ','”ÂAGY763','”ÂBR906K','”ÂB5B620','”ÂD5E225','”ÂAU3C50','”ÂAAS1038','”ÂDX6628','”ÂDZ9183','”ÂCDT806','”ÂD1P879','”ÂB206PH','”ÂC86L53','”ÂAAD0904','”ÂDGQ991','”ÂDGQ991','”ÂA3716V','”ÂA8BQ86','”ÂAA01982','”ÂA5MH76','”ÂAC45995','”ÂADT8936','”ÂDA0979','”ÂFCR825','”ÂA13T0F','”ÂCSL679','”ÂAK663E','”ÂAC05239','”ÂCLK758','”ÂABN3290','”ÂA0S3L9','”ÂAK9R17','”ÂAF20007','”ÂAD62887','”ÂB896TD','”ÂAA7U79','”ÂAX900D','”ÂA5Q70J','”ÂBBD896','”ÂA0RY35','”ÂBE372S','”ÂA7273C','”ÂBH938Q','”ÂANF368'";
        //∑¿÷π÷ÿ∏¥≥µ≈∆
        AtomicReference<String> rowStr= new AtomicReference<>("");
        //¥Ê‘⁄µƒ∞◊√˚µ•
        String filter="";


        Arrays.stream(fieldsSql.split(",")).forEach(row->{
            String row22 = row.substring(1, row.length()-1);
            if(filter.contains(row22)){
               //¥Ê‘⁄µƒ∞◊√˚µ•
//                System.out.println(row);
                return;
            }
            if(!rowStr.get().contains(row)  ){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2026-01-01 00:00:00', 0, 1, '2036-01-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª5¬º»Î20260122', %s, '19163154356', '∫´æ≤', 2);"
                        ,row,row.length()==10?4:0));

            }
        });

//        URLEncoder.encode("");
////        String ss=URLDecoder.decode("https://open.work.weixin.qq.com/wwopen/uriconfirm?err_type=param_err&uri=https%3A%2F%2Fopen.weixin.qq.com%2Fconnect%2Foauth2%2Fauthorize%3Fappid%3Dwx8697eec492141ca6%26redirect_uri%3Dhttp%253A%252F%252Ftxtestwww.meitianiot.com%252FroadParkScanPay%252Findex1.html%2523%252Fauthorization%253FscanType%253D1%2526plateNo%253D%2525E5%252590%252589LC0014%2526plateNoColour%253Dnull%2526parkId%253D1949727814434553856%2526howLong%253D137587000%2526parkItemName%253D2025001%2526isParkLock%253D0%2526payWay%253D30%2526inputMoney%253D2%2526payAbleMoney%253D2%2526orderIds%253D2508060947512197095%2526terminalLoginUserId%253D1952899886433045088%26response_type%3Dcode%26scope%3Dsnsapi_base%26state%3DSTATE%26connect_redirect%3D1%23wechat_redirect&ts=1754902479&nonce=1232afc65fcb2448&sig=bb1ce7c45a3d517f637391d1fb4a0e79c06f1029&sig_ver=2&bar_style_type=2&retry_time=1754902480041");
//        String ss=URLEncoder.encode("https://open.work.weixin.qq.com/wwopen/uriconfirm?err_type=param_err&uri=https%3A%2F%2Fopen.weixin.qq.com%2Fconnect%2Foauth2%2Fauthorize%3Fappid%3Dwx8697eec492141ca6%26redirect_uri%3Dhttp%253A%252F%252Ftxtestwww.meitianiot.com%252FroadParkScanPay%252Findex1.html%2523%252Fauthorization%253FscanType%253D1%2526plateNo%253D%2525E5%252590%252589LC0014%2526plateNoColour%253Dnull%2526parkId%253D1949727814434553856%2526howLong%253D137587000%2526parkItemName%253D2025001%2526isParkLock%253D0%2526payWay%253D30%2526inputMoney%253D2%2526payAbleMoney%253D2%2526orderIds%253D2508060947512197095%2526terminalLoginUserId%253D1952899886433045088%26response_type%3Dcode%26scope%3Dsnsapi_base%26state%3DSTATE%26connect_redirect%3D1%23wechat_redirect&ts=1754902479&nonce=1232afc65fcb2448&sig=bb1ce7c45a3d517f637391d1fb4a0e79c06f1029&sig_ver=2&bar_style_type=2&retry_time=1754902480041");
//        System.out.println(ss);
//        System.out.println(rowStr.get());


    }
}
