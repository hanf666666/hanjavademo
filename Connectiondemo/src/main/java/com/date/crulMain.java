package com.date;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/28
 */
public class crulMain {
    public static void main(String[] args) {
        String crul="curl \"http://betamanagegateway.meitianiot.com/api/cloudMsManage/v1/system/ms/userDelete\" ^\n" +
                "  -H \"Accept: */*\" ^\n" +
                "  -H \"Accept-Language: zh-CN,zh;q=0.9\" ^\n" +
                "  -H \"Connection: keep-alive\" ^\n" +
                "  -H \"Content-Type: application/x-www-form-urlencoded\" ^\n" +
                "  -H \"Origin: http://betacloudpark.meitianiot.com\" ^\n" +
                "  -H \"Referer: http://betacloudpark.meitianiot.com/\" ^\n" +
                "  -H \"SCOPE: cloudMsManage\" ^\n" +
                "  -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36\" ^\n" +
                "  -H \"accesstoken: ef8a40bf-1968-44d9-a473-f26cccbbdf11\" ^\n" +
                "  -H \"projectId: 7\" ^\n" +
                "  -H \"userid: 11464\" ^\n" +
                "  -H \"username: testyb\" ^\n" +
                "  --data-raw \"id=11578\" ^\n" +
                "  --compressed ^\n" +
                "  --insecure";

        System.out.println(crul.replaceAll("\\^",""));
    }
}
