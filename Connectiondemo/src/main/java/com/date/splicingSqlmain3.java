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
        String fieldsSql = "'”ÂBJ723A','”ÂBJ8683','”ÂAFX2927','”ÂBR881C','”ÂB17P80','”ÂAMV115','”ÂALY932','”ÂBY015J','”ÂBPA389','”ÂA3QQ96','”ÂAM089V','”ÂA2LP86','”ÂA5T6C6','”ÂA6ES10','”ÂAFF9415','”ÂB261DP','”ÂA20Z6Q','”ÂAF13537','”ÂA9RY71','”ÂA62C31','”ÂAC09016','”ÂAU3U48','”ÂD53A93','”ÂARW704','”ÂAD39262','”ÂB11A78','”ÂADL509','”ÂA25X36','”ÂAPV619','”ÂDC7905','”ÂA127V7','”ÂAF82419','”ÂA70F9Y','”ÂDNA270','”ÂAAS7567','”ÂGN2169','”ÂB767VP','”ÂA07SD3','”ÂA1696V','”ÂG1G300','”ÂA9Q36D','”ÂAD93615','”ÂAZS910','”ÂDDT117','”ÂGQ1238','”ÂG61B62','∂ıA756AT','”ÂAZ5V50','”ÂAF5359','”ÂA07J0X','ºΩRP63M9','”ÂA66FJ1','”ÂBS849Q','¬≥R7S15V','”ÂA3C65Y','”ÂA091E2','”ÂAD60922','”ÂAFJ3128','”ÂABX306','”ÂD567G5','”ÂBA100Q','”ÂA4346E','”ÂAFT9911','”ÂDMP898','”ÂBK201S','”ÂBJ915E','”ÂD82C92','”ÂB9E056','”ÂF893H6','”ÂFW8103','”ÂDR6551','”ÂA5ZL22','”ÂA70077','”ÂAT6W73','”ÂBR9546','”ÂD83C06','”ÂD3R173','”ÂBJP105','”ÂBMA972','”ÂAE92M2','”ÂA0X5G2','”ÂADD6683','”ÂAQ78B2','”ÂAL90N9','”ÂBJA159','”ÂA237KC','”ÂB1D887','”ÂB71G28','”ÂAF69373','”ÂBAM165','”ÂBJM703','”ÂDDQ018','”ÂAAA6273','”ÂAF391W','¥®ZTM335','”ÂAFH1280','”ÂBE829J','”ÂBTE971','”ÂAE08B5','”ÂBWP548','”ÂAM87A7','”ÂAU932R','”ÂAFJ9305','”ÂAB96118','”ÂD8J638','”ÂAH02S0','”ÂCSR659','”ÂAAW9748','”ÂADA392','¥®R8P331','”ÂDV9660','”ÂBGH011','”ÂABE76S','”ÂAC69328','”ÂADL5135','”ÂAAH1877','”ÂGFV255','”ÂAGR9933','‘¡E2629Y','”ÂABY5180','”ÂA75M0L','πÛC177R5','”ÂA27T1P','”ÂD161X8','”ÂB2B693','”ÂALW782','”ÂAGN8589','”ÂAG63200','”ÂAS2464','”ÂBJ723A','”ÂBJ8683','”ÂA3QQ96','”ÂAM089V','”ÂA2LP86','”ÂA5T6C6','”ÂA6ES10','”ÂAFF9415','”ÂB261DP','”ÂA20Z6Q','”ÂAF13537','”ÂA9RY71','”ÂA62C31','”ÂAC09016','”ÂAU3U48'";

        //∑¿÷π÷ÿ∏¥≥µ≈∆
        AtomicReference<String> rowStr= new AtomicReference<>("");
        //¥Ê‘⁄µƒ∞◊√˚µ•
        String filter="ºΩRP63M9,¥®ZTM335,”ÂA07J0X,”ÂA07SD3,”ÂA091E2,”ÂA0X5G2,”ÂA127V7,”ÂA1696V,”ÂA20Z6Q,”ÂA237KC,”ÂA25X36,”ÂA3C65Y,”ÂA4346E,”ÂA5ZL22,”ÂA62C31,”ÂA66FJ1,”ÂA70077,”ÂA70F9Y,”ÂA9Q36D,”ÂA9RY71,”ÂAAA6273,”ÂAAS7567,”ÂAB96118,”ÂAC09016,”ÂAD60922,”ÂAD93615,”ÂADA392,”ÂADD6683,”ÂADL509,”ÂAE08B5,”ÂAE92M2,”ÂAF13537,”ÂAF391W,”ÂAF5359,”ÂAF69373,”ÂAF82419,”ÂAFH1280,”ÂAFJ3128,”ÂAFJ9305,”ÂAFT9911,”ÂAH02S0,”ÂAL90N9,”ÂAM87A7,”ÂAPV619,”ÂAQ78B2,”ÂAT6W73,”ÂAU932R,”ÂAZ5V50,”ÂAZS910,”ÂB17P80,”ÂB1D887,”ÂB71G28,”ÂB767VP,”ÂB9E056,”ÂBA100Q,”ÂBAM165,”ÂBE829J,”ÂBJ915E,”ÂBJA159,”ÂBJM703,”ÂBJP105,”ÂBK201S,”ÂBMA972,”ÂBR9546,”ÂBS849Q,”ÂBTE971,”ÂBWP548,”ÂCSR659,”ÂD3R173,”ÂD567G5,”ÂD82C92,”ÂD83C06,”ÂD8J638,”ÂDC7905,”ÂDDQ018,”ÂDDT117,”ÂDMP898,”ÂDNA270,”ÂDR6551,”ÂDV9660,”ÂF893H6,”ÂFW8103,”ÂG1G300,”ÂG61B62,”ÂGN2169,”ÂGQ1238,∂ıA756AT,¬≥R7S15V";
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
                        "VALUES(null, 1, '2025-12-10 00:00:00', 0, 1, '2035-12-01 00:00:00', %s, '≤–º≤≥µÕ≥“ª5¬º»Î20251210', %s, '19163154356', '∫´æ≤', 2);"
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
