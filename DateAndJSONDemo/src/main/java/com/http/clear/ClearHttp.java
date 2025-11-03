package com.http.clear;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2024/12/14
 */
@Slf4j
public class ClearHttp {
    public static void main(String[] args) {

        // 创建一个 HttpRequest 对象
//        String url = "http://managegateway.meitianiot.com/api/clearingPlat/v1/settleCreated/settlementpage";
        String url = "http://managegateway.meitianiot.com/api/clearingPlat/v1/settlement/confirm";

        HttpRequest request = HttpRequest.post(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:144.0) Gecko/20100101 Firefox/144.0")
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("X-URL-PATH", "/")
                .header("x-access-token", "nxozvnwaya1rwfqjlnnsx6dnposqafbv")
                .header("TOKEN", "nxozvnwaya1rwfqjlnnsx6dnposqafbv")
                .header("USER_ID", "797")
                .header("TIMESTAMP", "1762170756000")
                .header("TRACE_ID", "QjbcePs2")
                .header("SIGN", "89e5e38bd4440646086bc102beaf5c4f")
                .header("SCOPE", "clearingPlat")
                .header("Origin", "http://clearingplat.meitianiot.com")
                .header("Connection", "keep-alive")
                .header("Referer", "http://clearingplat.meitianiot.com/")
                .header("Priority", "u=0");
        Map<String, Object> paramMap = new HashMap<>();
//           "model": "deepseek-chat",
//        "messages": [
//          {"role": "system", "content": "You are a helpful assistant."},
//          {"role": "user", "content": "Hello!"}
//        ],
//        "stream": false
        paramMap.put("settlementNo","JS1762151603795");


        request.body(JSONUtil.toJsonStr(paramMap));

        // 发送请求并获取响应
        HttpResponse response = request.execute();
        log.info("响应数据: {}", response.body());




    }
}
