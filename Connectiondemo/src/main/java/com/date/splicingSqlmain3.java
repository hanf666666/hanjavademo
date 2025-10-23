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
        String fieldsSql = "'”ÂA25X36','”ÂAPV619','”ÂDC7905','”ÂA127V7','”ÂAF82419','”ÂA70F9Y','”ÂDNA270','”ÂAAS7567','”ÂGN2169','”ÂB767VP','”ÂA07SD3','”ÂA1696V','”ÂG1G300','”ÂA9Q36D','”ÂAD93615','”ÂAZS910','”ÂDDT117','”ÂGQ1238','”ÂG61B62','∂ıA756AT','”ÂAZ5V50','”ÂAF5359','”ÂA07J0X','ºΩRP63M9','”ÂA66FJ1','”ÂBS849Q','¬≥R7S15V','”ÂA3C65Y','”ÂA20Z6Q','”ÂA091E2','”ÂAD60922','”ÂAFJ3128','\"”ÂABX306','”ÂAF13537','”ÂA9RY71','”ÂA62C31','”ÂAC09016','”ÂD567G5','”ÂBA100Q','”ÂA4346E','”ÂAFT9911','”ÂDMP898','”ÂBK201S','”ÂBJ915E','”ÂD82C92','”ÂB9E056','”ÂF893H6','”ÂFW8103','”ÂDR6551','”ÂA5ZL22','”ÂA70077','”ÂAT6W73','”ÂBR9546','”ÂD83C06','”ÂD3R173','”ÂBJP105','”ÂBMA972','”ÂAE92M2','”ÂA0X5G2','”ÂADD6683','”ÂAQ78B2','”ÂAL90N9','”ÂBJA159','”ÂA237KC','”ÂB1D887','”ÂB71G28','AF69373','”ÂBAM165','”ÂBJM703','”ÂDDQ018','”ÂAAA6273','”ÂAF391W','¥®ZTM335','”ÂAFH1280','”ÂBE829J','”ÂBTE971','”ÂBJA159','”ÂAE08B5','”ÂBWP548','”ÂA03R7E','”ÂAM87A7','”ÂAU932R','”ÂAFJ9305','”ÂAB96118','”ÂD8J638','”ÂA222FP','”ÂAH02S0','…¬AFX2927','”ÂCSR659','”ÂADL509'";
        AtomicReference<String> rowStr= new AtomicReference<>("");
        String filter="'ºΩRP63M9','¥®ZTM335','”ÂA07J0X','”ÂA0X5G2','”ÂA237KC','”ÂA25X36','”ÂA66FJ1','”ÂADD6683','”ÂAE92M2','”ÂAF391W','”ÂAF5359','”ÂAL90N9','”ÂAPV619','”ÂAQ78B2','”ÂAZ5V50','”ÂAZS910','”ÂB1D887','”ÂB71G28','”ÂBAM165','”ÂBJA159','”ÂBJM703','”ÂBJP105','”ÂBMA972','”ÂCSR659','”ÂDC7905','”ÂDDQ018','”ÂDDT117','”ÂG61B62','”ÂGQ1238','∂ıA756AT'";
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
                        "VALUES(null, 1, '2025-10-01 00:00:00', 0, 1, '2035-10-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª5¬º»Î20251023', %s, '19163154356', '∫´æ≤', 2);"
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
