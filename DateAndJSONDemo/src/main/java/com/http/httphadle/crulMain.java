package com.http.httphadle;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/28
 */
public class crulMain {
    public static void main(String[] args) {
        Object object = 1;
        System.out.println(object.equals("1"));

//        String curl="curl \"http://test1managegateway.meitianiot.com/api/cloudMsManage/v1/park/runConfig/listParkByUser\" ^\n" +
//                "  -X \"POST\" ^\n" +
//                "  -H \"Accept: */*\" ^\n" +
//                "  -H \"Accept-Language: zh-CN,zh;q=0.9\" ^\n" +
//                "  -H \"Connection: keep-alive\" ^\n" +
//                "  -H \"Content-Length: 0\" ^\n" +
//                "  -H \"Origin: http://localhost:8082\" ^\n" +
//                "  -H \"Referer: http://localhost:8082/\" ^\n" +
//                "  -H \"SCOPE: cloudMsWorkPosition\" ^\n" +
//                "  -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36\" ^\n" +
//                "  -H \"accesstoken: 194c24de-91ac-4d34-bea0-34e8806e9a75\" ^\n" +
//                "  -H \"projectId: 7\" ^\n" +
//                "  -H \"userid: 11867\" ^\n" +
//                "  -H \"username: lxh\" ^\n" +
//                "  --compressed ^\n" +
//                "  --insecure";

        String curl="curl.exe ^\"http://managegateway.meitianiot.com/api/clearingPlat/v1/settleCreated/settlementpage^\" ^\n" +
                "  -X POST ^\n" +
                "  -H ^\"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:144.0) Gecko/20100101 Firefox/144.0^\" ^\n" +
                "  -H ^\"Accept: application/json, text/plain, */*^\" ^\n" +
                "  -H ^\"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2^\" ^\n" +
                "  -H ^\"Accept-Encoding: gzip, deflate^\" ^\n" +
                "  -H ^\"Content-Type: application/x-www-form-urlencoded^\" ^\n" +
                "  -H ^\"X-URL-PATH: /^\" ^\n" +
                "  -H ^\"x-access-token: dg507g5s4y2rsvzk7rahkljkyhx3s1zv^\" ^\n" +
                "  -H ^\"TOKEN: dg507g5s4y2rsvzk7rahkljkyhx3s1zv^\" ^\n" +
                "  -H ^\"USER_ID: 797^\" ^\n" +
                "  -H ^\"TIMESTAMP: 1762169680000^\" ^\n" +
                "  -H ^\"TRACE_ID: JAR4V8zf^\" ^\n" +
                "  -H ^\"SIGN: e23205bb7657ec355c4c0b967bfb29d4^\" ^\n" +
                "  -H ^\"SCOPE: clearingPlat^\" ^\n" +
                "  -H ^\"Origin: http://clearingplat.meitianiot.com^\" ^\n" +
                "  -H ^\"Connection: keep-alive^\" ^\n" +
                "  -H ^\"Referer: http://clearingplat.meitianiot.com/^\" ^\n" +
                "  -H ^\"Priority: u=0^\" ^\n" +
                "  --data-raw ^\"pageIndex=0^&pageCount=10^&parkOwner=66^&parkName=^&clearType=^&settlementStatus=^&providerService=^&transeferSuccessDtStart=^&transeferSuccessDtEnd=^&endTimeStart=^&endTimeEnd=^&settlePayId=^\"";


        System.out.println(curl.replaceAll("\\^",""));


    }
}
