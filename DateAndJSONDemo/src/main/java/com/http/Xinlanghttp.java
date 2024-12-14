package com.http;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * to do
 *
 * @author Hj
 * @date 2024/12/14
 */
@Slf4j
public class Xinlanghttp {
    public static void main(String[] args) {

        //-H "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:133.0) Gecko/20100101 Firefox/133.0" -H "Accept: */*" -H "Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2" -H "Accept-Encoding: gzip, deflate, br, zstd" -H "Connection: keep-alive" -H "Referer: https://finance.sina.com.cn/" -H "Sec-Fetch-Dest: script" -H "Sec-Fetch-Mode: no-cors" -H "Sec-Fetch-Site: cross-site" -H "Pragma: no-cache" -H "Cache-Control: no-cache"

        // 创建一个 HttpRequest 对象
        HttpRequest request = HttpRequest.post("https://hq.sinajs.cn/etag.php?_=1734144626870&list=sz002175")
                .header("https", "//hq.sinajs.cn/etag.php?_=1734144626870&list=sz002175")
                .header("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:133.0) Gecko/20100101 Firefox/133.0")
                .header("Accept", " */*")
                .header("Accept-Language", " zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Accept-Encoding", " gzip, deflate, br, zstd")
                .header("Connection", " keep-alive")
                .header("Referer", " https://finance.sina.com.cn/")
                .header("Sec-Fetch-Dest", " script")
                .header("Sec-Fetch-Mode", " no-cors")
                .header("Sec-Fetch-Site", " cross-site")
                .header("Pragma", " no-cache")
                .header("Cache-Control", " no-cache");

        // 发送请求并获取响应
        HttpResponse response = request.execute();
        log.info("响应状态码: {}", response.body());





    }
}
