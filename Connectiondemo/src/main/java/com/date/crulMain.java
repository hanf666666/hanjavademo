package com.date;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/28
 */
public class crulMain {
    public static void main(String[] args) {
        String curl="curl \"http://betamanagegateway.meitianiot.com/api/cloudMsManage/v1/system/ms/userDelete\" ^\n" +
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

       curl= "curl \"http://betamanagegateway.meitianiot.com/api/rbac/v1/systemManage/user/remove\" -X POST -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/111.0\" -H \"Accept: application/json, text/plain, */*\" -H \"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\" -H \"Accept-Encoding: gzip, deflate\" -H \"Content-Type: application/json;charset=UTF-8\" -H \"X-URL-PATH: /\" -H \"x-access-token: f5143604-4d77-4534-b691-7130edfceb8e\" -H \"accesstoken: f5143604-4d77-4534-b691-7130edfceb8e\" -H \"userid: 10386\" -H \"username: hanjing1\" -H \"scope: bossManage\" -H \"projectId: 1\" -H \"Origin: http://betaboss.meitianiot.com\" -H \"Connection: keep-alive\" -H \"Referer: http://betaboss.meitianiot.com/\" --data-raw \"{\"\"id\"\":11581}\"";

        System.out.println(curl.replaceAll("\\^",""));


    }
}
