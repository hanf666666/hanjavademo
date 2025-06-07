package com.http.httphadle;

import java.util.Arrays;

/**
 * to do
 *
 * @author Hj
 * @date 2023/3/28
 */
public class CrulgetHeaderMain {
    public static void main(String[] args) {
//        String url="curl \"https://hq.sinajs.cn/etag.php?_=1734144626870&list=sz002175\" --compressed -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:133.0) Gecko/20100101 Firefox/133.0\" -H \"Accept: */*\" -H \"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\" -H \"Accept-Encoding: gzip, deflate, br, zstd\" -H \"Connection: keep-alive\" -H \"Referer: https://finance.sina.com.cn/\" -H \"Sec-Fetch-Dest: script\" -H \"Sec-Fetch-Mode: no-cors\" -H \"Sec-Fetch-Site: cross-site\" -H \"Pragma: no-cache\" -H \"Cache-Control: no-cache\"";
//        String url="curl \"https://chat.baidu.com/csaitab/history/delete\"   -X POST   -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0\"   -H \"Accept: */*\"   -H \"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\"   -H \"Accept-Encoding: gzip, deflate, br, zstd\"   -H \"Content-Type: text/plain;charset=UTF-8\"   -H \"Referer: https://chat.baidu.com/aichat/history\"   -H \"Origin: https://chat.baidu.com\"   -H \"Sec-Fetch-Dest: empty\"   -H \"Sec-Fetch-Mode: cors\"   -H \"Sec-Fetch-Site: same-origin\"   -H \"Connection: keep-alive\"   -H \"Cookie: BAIDUID=C53A3A8527B1A11FBC4F4AD2E49AABD3:SL=0:NR=10:FG=1; BIDUPSID=C53A3A8527B1A11FCE6561DE835B137F; PSTM=1747788992; H_PS_PSSID=62325_63145_63210_63243_63269_63326_63389_63380_63391_63404_63442; BDUSS=lI1M1V0SW5NN2MwR0RpVXBHfjJPR3kwaFMwWkhwSURqV284QzFPQlJZbllzVlJvSVFBQUFBJCQAAAAAAAAAAAEAAADLEvpS17fW8NXfNjY2NjY2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANgkLWjYJC1oT; H_WISE_SIDS=62325_63145_63210_63243_63269_63326_63389_63380_63391_63404_63442; MCITY=-330%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; PSINO=6; BDRCVFR[feWj1Vr5u3D]=mk3SLVN4HKm; BA_HECTOR=21ak00al2h8084850h2k2000ah252g1k4307425; ZFY=NBLohc9hFwNgUh01m2Sa:AMu4BdpOJ29JfJdBrOIg7xQ:C\"   -H \"Priority: u=0\"   --data-raw \"{\\\"req_type\\\":1,\\\"ori_lid_list\\\":[{\\\"ori_lid\\\":\\\"16727450639161452305\\\"}]}\"";
        String url = "curl \"https://chat.deepseek.com/api/v0/chat_session/delete\"   -X POST   -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0\"   -H \"Accept: */*\"   -H \"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\"   -H \"Accept-Encoding: gzip, deflate, br, zstd\"   -H \"x-client-platform: web\"   -H \"x-client-version: 1.2.0-sse-hint\"   -H \"x-client-locale: zh_CN\"   -H \"x-app-version: 20241129.1\"   -H \"authorization: Bearer qPlS0rGG3qU0mebozG+kxur7r6VFT8cHw/Y3WTbc8CZDnhJmkeKONGEJapJv1pWx\"   -H \"content-type: application/json\"   -H \"Origin: https://chat.deepseek.com\"   -H \"Connection: keep-alive\"   -H \"Referer: https://chat.deepseek.com/\"   -H \"Cookie: .thumbcache_6b2e5483f9d858d7c661c5e276b6a6ae=NiRFURXg4/Dq4ym8x6SxJon0Z/LKzSMfICM8wJhcsxQwTyFOkaz44Kqbk7cFtpihWr6ZdoD+UwANtLIOHfsBqQ%3D%3D; smidV2=202505271015208fa7a3d358c7cfa2de44e7260a4f2755009e5b68921bc12d0; intercom-session-guh50jw4=QTZVZ0lwenhwcWpDZERmZ2FEeHREa2ExVUV1a0ZscFRrM0ZPZ3Qxa2t4RUxkTXNlRGxlQWtVRjFIZDN2dlA3Z3l6ZUtXYjUrV0EySDVTL1R1T0l1bjJzT1BOQnhqNDF4aU9jSEFTNkhlcHM9LS1abFgzR21xZ2dHSk9EQVdWQUl6L1d3PT0=--fd6d9eee7adefc0fdf33f8ddb88971b08a456b78; intercom-device-id-guh50jw4=9a698c8c-7fc8-4f6e-9e51-a788901bc542; HWWAFSESID=1449c52303ee0d43609; HWWAFSESTIME=1749258666691; ds_session_id=578fbae9300b45e390ff01fcc644598d\"   -H \"Sec-Fetch-Dest: empty\"   -H \"Sec-Fetch-Mode: cors\"   -H \"Sec-Fetch-Site: same-origin\"   -H \"Priority: u=0\"   -H \"TE: trailers\"   --data-raw \"{\\\"chat_session_id\\\":\\\"bf08a402-05fa-4c34-aa65-dae2acd2b5b7\\\"}\"";
//        System.out.println(url.replaceAll("\\^",""));
        Arrays.asList(url.split("\"")).forEach(row -> {
            if (row.contains(":")) {
                String[] split = row.split(":");
                String key = split[0];
                String value = "";
                for (int i = 1; i < split.length; i++) {
                    value += (":" + split[i]);
                }
                value = value.substring(2, value.length());
                System.out.println(".header(\"" + key + "\", \"" + value + "\")");
            }
        });


    }
}
