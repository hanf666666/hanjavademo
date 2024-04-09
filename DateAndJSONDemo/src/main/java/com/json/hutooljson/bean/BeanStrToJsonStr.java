package com.json.hutooljson.bean;

/**
 * to do
 * bean (queue=null转 jsonstr
 * @author Hj
 * @date 2024/3/26
 */
public class BeanStrToJsonStr {
    public static void main(String[] args) {
//        String s = "{code=200.0, message=业务成功, localizedMsg=null, data={carStock=0.0, plateNo=渝A1LZ91, shouldPay=10.0, discountAmount=0.0, paidType=2.0, dealTime=2024-03-26 11:12:57, billID=2403261111239879012, orderCode=, askOrderTime=2024-03-26 11:12:56, payStatus=1.0, actualPay=10.0}}";
        String s = "(queue=null, code=1, msg=null, opt=222, uuid=a5b48833-1e89-48e9-aba3-7b96df0eb19e, serviceId=sync.enter.in.record, parkCode=TDZN/103116P14682, dataItems=[{groupUuid=10S1SD73LE0CWNBJ16XIZIM1M05FKP6U, groupId=43, enterOpId=3, enterPicSmall=http://88_da_a0_0_2f_2d.tdzntech.com:9898/ftpdir/pic/Recognize/20240326/192.168.2.113_2024032617091071603_2654_M.jpg, recordId=119034, inMac=88_da_a0_0_2f_2d, plateColorTxt=蓝, carSubType=81, carType=8, workspaceIp=192.168.2.150, enterOpame=222, totalParkNum=600, enterPicSmallSsl=https://88_da_a0_0_2f_2d.tdzntech.com:9696/ftpdir/pic/Recognize/20240326/192.168.2.113_2024032617091071603_2654_M.jpg, remainParkNum=471, inChannelid=1, cplx=02, entrance=车库1入口, isportmapping=0, jckbh=1, enterTime=2024-03-26 17:09:10, cb=, routerip=192.168.1.1, carStatus=1, zxd=99, enterPic=http://88_da_a0_0_2f_2d.tdzntech.com:9898/ftpdir/pic/Recognize/20240326/192.168.2.113_2024032617091071603_2654.jpg, hardwareUuid=8B1B14C7BF9B11D3A67B021875CD22A8, sfwc=1, trigger=0, plateNumber=湘LLW079, jckmc=1, clys=255, recordNo=C57B7235242645FAB1EEF8E682D9A630, groupName=206, bcbz=1, enterPicSsl=https://88_da_a0_0_2f_2d.tdzntech.com:9696/ftpdir/pic/Recognize/20240326/192.168.2.113_2024032617091071603_2654.jpg, routerport=80, recognizeType=2}], action=null, timestamp=2024-03-26 17:09:11, clientId=TDZN/103116P14682_192.168.2.150, mac=88_da_a0_0_2f_2d)";

                s = s.replaceAll("\\{", "{'");
        s = s.replaceAll("}", "'}");
        s = s.replaceAll("=", "':'");
        s = s.replaceAll(", ", "','");
        s = s.replaceAll("'\\{'", "{'");
        s = s.replaceAll("'}'", "'}");
        s = s.replaceAll("'", "\"");
        System.out.println(s);
    }
}
