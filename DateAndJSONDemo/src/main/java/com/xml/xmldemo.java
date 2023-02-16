package com.xml;

import com.github.wxpay.sdk.WXPayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/22
 */
public class xmldemo {
    public static void main(String[] args) {



        Map param = new HashMap();


        param.put("spbill_create_ip","192.168.127.222");
        param.put("notify_url","http://www.jd222.com");
        param.put("trade_type","NATIVE");


        //将map数据转换成带签名的xml数据
        String s = null;
        try {
            s = WXPayUtil.generateSignedXml(param, "2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
