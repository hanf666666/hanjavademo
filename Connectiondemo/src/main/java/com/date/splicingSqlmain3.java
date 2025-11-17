package com.date;

import java.net.URLDecoder;
import java.net.URLEncoder;
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
        String fieldsSql = "'”ÂAD67839','”ÂA88M2E','”ÂAGM8355','”ÂA62P7N','”ÂA82AW0','”ÂAB148E','”ÂC73F03','”ÂAT8X30','”ÂAFP9369','”ÂAGK7817','”ÂAGH0011','”ÂAA41812','”ÂA5365W','”ÂAC25971','”ÂBV883U','”ÂAB33323','”ÂAK662R','”ÂA035SA','”ÂA568BN','”ÂA67R9E','”ÂGEN278','”ÂAW7C59','”ÂG7A815','”ÂDW4972','”ÂAC22K5','”ÂAH37J0','”ÂBTQ946','”ÂAF65195','”ÂD82B38','”ÂA728N1','”ÂD6T930','”ÂA90DZ2','”ÂA8681J','”ÂG6K636'";

        AtomicReference<String> rowStr= new AtomicReference<>("");
        String filter="'”ÂAD67839fasdfa'";
        Arrays.stream(fieldsSql.split(",")).forEach(row->{
//            row = row.substring(1, row.length()-1);
            if(filter.contains(row)){
//                System.out.println(row);
                return;
            }
            if(!rowStr.get().contains(row)  ){
                rowStr.set(rowStr.get()+","+row);
//                System.out.println(row);
                System.out.println(String.format(" INSERT INTO meisoodev.user_white_list(white_list_id, created_by, created_dt, deleted, deleted_by, deleted_dt, plate_no, remark, plate_no_colour, phone, name, white_list_type) " +
                        "VALUES(null, 1, '2025-11-10 00:00:00', 0, 1, '2035-11-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª5¬º»Î20251110', %s, '19163154356', '∫´æ≤', 2);"
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
