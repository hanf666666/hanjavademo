package com.http;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;

/**
 * @author Hj
 * @date 2025/8/7
 */
public class aaa {
    public static void main(String[] args) {
//        6d8a51
        //74, certNo=415230625_1761894584773, trCode=210201, corpNo=0010027838, trAcdt=20251031, trTime=150942, serialNo=, atomTrCount=1, particularCode=9100, receiptDate=null, receiptNumber=null,
        //74, certNo=415230625_1761894584773, trCode=210201, corpNo=0010027838, trAcdt=20251031, trTime=150942, serialNo=, atomTrCount=1, particularCode=9100, receiptDate=null, receiptNumber=null,
        //74, certNo=cbvql1_1761894584773, trCode=210201, corpNo=0010027838, trAcdt=20251031, trTime=150942, serialNo=, atomTrCount=1, particularCode=9100, receiptDate=null, receiptNumber=null,

        System.out.println(Integer.toString(415230625, 32));
        DateTime offset = DateUtil.date();
        DateTime offset2=offset;
        System.out.println(offset2);
        DateTime offset1 = offset.offsetNew(DateField.MONTH, 1);
        System.out.println(offset);
        System.out.println(offset1);
        System.out.println(offset2);

        String ss="https://www.meitianiot.com,https://wxsr.meitianiot.com,http://k8sapi.meitianiot.com,http://k8swww.meitianiot.com,http://realdata.meitianiot.com,http://www.meitianiot.com,http://api.meitianiot.com,https://api.meitianiot.com,https//k8swww.meitianiot.com,https://webrtch5.meitianiot.com,https://txwww.meitianiot.com,http://txwww.meitianiot.com";
        Arrays.stream(ss.split(",")).forEach(
                row->{
                    System.out.println(row);
                }
        );
    }
}
