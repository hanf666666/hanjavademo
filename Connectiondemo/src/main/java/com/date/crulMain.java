package com.date;

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

        String curl="curl \"http://betamanagegateway.meitianiot.com/api/bossManage/v1/advertising/management/page\" ^\n" +
                "  -H \"Accept: application/json, text/plain, */*\" ^\n" +
                "  -H \"Accept-Language: zh-CN,zh;q=0.9\" ^\n" +
                "  -H \"Connection: keep-alive\" ^\n" +
                "  -H \"Content-Type: application/json;charset=UTF-8\" ^\n" +
                "  -H \"Origin: http://localhost:9528\" ^\n" +
                "  -H \"Referer: http://localhost:9528/\" ^\n" +
                "  -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36\" ^\n" +
                "  -H \"X-URL-PATH: /\" ^\n" +
                "  -H \"accesstoken: 7b61c316-b0c6-49e1-a42c-acb2d736e7b7\" ^\n" +
                "  -H \"projectId: 1\" ^\n" +
                "  -H \"scope: bossManage\" ^\n" +
                "  -H \"userid: 11838\" ^\n" +
                "  -H \"username: zhaoyangyang\" ^\n" +
                "  -H \"x-access-token: 7b61c316-b0c6-49e1-a42c-acb2d736e7b7\" ^\n" +
                "  --data-raw ^\"^{^\\^\"pageIndex^\\^\":1,^\\^\"pageCount^\\^\":10,^\\^\"name^\\^\":^\\^\"^\\^\",^\\^\"position^\\^\":^\\^\"^\\^\",^\\^\"status^\\^\":^\\^\"^\\^\"^}^\" ^\n" +
                "  --insecure";


        System.out.println(curl.replaceAll("\\^",""));


    }
}
