package com.http.deepseek;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试demo
 *
 * @author Hj
 * @date 2025/2/7
 */
@Slf4j
public class DeepseekDemo {
    public static void main(String[] args) {
        //-H "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:133.0) Gecko/20100101 Firefox/133.0" -H "Accept: */*" -H "Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2" -H "Accept-Encoding: gzip, deflate, br, zstd" -H "Connection: keep-alive" -H "Referer: https://finance.sina.com.cn/" -H "Sec-Fetch-Dest: script" -H "Sec-Fetch-Mode: no-cors" -H "Sec-Fetch-Site: cross-site" -H "Pragma: no-cache" -H "Cache-Control: no-cache"

        // 创建一个 HttpRequest 对象
//        HttpRequest request = HttpRequest.post("https://hq.sinajs.cn/etag.php?_=1734144626870&list=sz002175")
        String url = "https://api.deepseek.com/chat/completions";

        HttpRequest request = HttpRequest.post(url)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer sk-00e247829fb548e4b18e00502e496094");
        Map<String, Object> paramMap = new HashMap<>();
//           "model": "deepseek-chat",
//        "messages": [
//          {"role": "system", "content": "You are a helpful assistant."},
//          {"role": "user", "content": "Hello!"}
//        ],
//        "stream": false
        paramMap.put("model","deepseek-chat");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> paramMap21 = new HashMap<>();
        paramMap21.put("role","system");
        paramMap21.put("content","中国和美国gdp");
        list.add(paramMap21);
//        Map<String, Object> paramMap22 = new HashMap<>();
//        paramMap22.put("role","user");
//        paramMap22.put("content","Hello!");
//        list.add(paramMap22);

        paramMap.put("messages",list);
        paramMap.put("stream",false);

        request.body(JSONUtil.toJsonStr(paramMap));

        // 发送请求并获取响应
        HttpResponse response = request.execute();
        log.info("响应数据: {}", response.body());
    }

}
