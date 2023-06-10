package com.date;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/28
 */
public class crulMain {
    public static void main(String[] args) {
        String curl="curl \"http://test1managegateway.meitianiot.com/api/cloudMsManage/v1/park/runConfig/listParkByUser\" ^\n" +
                "  -X \"POST\" ^\n" +
                "  -H \"Accept: */*\" ^\n" +
                "  -H \"Accept-Language: zh-CN,zh;q=0.9\" ^\n" +
                "  -H \"Connection: keep-alive\" ^\n" +
                "  -H \"Content-Length: 0\" ^\n" +
                "  -H \"Origin: http://localhost:8082\" ^\n" +
                "  -H \"Referer: http://localhost:8082/\" ^\n" +
                "  -H \"SCOPE: cloudMsWorkPosition\" ^\n" +
                "  -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36\" ^\n" +
                "  -H \"accesstoken: 194c24de-91ac-4d34-bea0-34e8806e9a75\" ^\n" +
                "  -H \"projectId: 7\" ^\n" +
                "  -H \"userid: 11867\" ^\n" +
                "  -H \"username: lxh\" ^\n" +
                "  --compressed ^\n" +
                "  --insecure";


        System.out.println(curl.replaceAll("\\^",""));


    }
}
