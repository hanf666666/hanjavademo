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
        String url="curl \"https://hq.sinajs.cn/etag.php?_=1734144626870&list=sz002175\" --compressed -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:133.0) Gecko/20100101 Firefox/133.0\" -H \"Accept: */*\" -H \"Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2\" -H \"Accept-Encoding: gzip, deflate, br, zstd\" -H \"Connection: keep-alive\" -H \"Referer: https://finance.sina.com.cn/\" -H \"Sec-Fetch-Dest: script\" -H \"Sec-Fetch-Mode: no-cors\" -H \"Sec-Fetch-Site: cross-site\" -H \"Pragma: no-cache\" -H \"Cache-Control: no-cache\"";

//        System.out.println(url.replaceAll("\\^",""));
        Arrays.asList(url.split("\"")).forEach(row->{
            if(row.contains(":")){
                String[] split = row.split(":");
                String key=split[0];
                String value="";
                for (int i = 1; i < split.length; i++) {
                    value+=(":"+split[i]);
                }
                value=value.substring(2,value.length());
                System.out.println(".header(\""+key+"\", \""+value+"\")");
            }
        });



    }
}
