package com.http.deepseek.delete;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * to do
 *
 * @author Hj
 * @date 2024/12/14
 */
@Slf4j
public class DeepseekHttp {
    public static void main(String[] args) {
        // 创建一个 HttpRequest 对象
        String url = "https://chat.deepseek.com/api/v0/chat_session/delete";
        //json的数据来源 https://chat.deepseek.com/api/v0/chat_session/fetch_page
        FileReader fileReader = new FileReader("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\src\\main\\java\\com\\http\\deepseek\\delete\\data.json");
        String result = fileReader.readString();
        System.out.println(result);
        JSONArray jsonArray = JSONUtil.parseObj(result).getJSONObject("data").getJSONObject("biz_data").getJSONArray("chat_sessions");
        jsonArray.stream().forEach(row->{
            JSONObject jsonObject = (JSONObject) row;
            String session_id = jsonObject.getStr("id");
            System.out.println(session_id);
            HttpRequest request = HttpRequest.post(url).body("{\"chat_session_id\":\""+session_id+"\"}")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0")
                    .header("Accept", "*/*")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                    .header("Accept-Encoding", "gzip, deflate, br, zstd")
                    .header("x-client-platform", "web")
                    .header("x-client-version", "1.2.0-sse-hint")
                    .header("x-client-locale", "zh_CN")
                    .header("x-app-version", "20241129.1")
                    .header("authorization", "Bearer qPlS0rGG3qU0mebozG+kxur7r6VFT8cHw/Y3WTbc8CZDnhJmkeKONGEJapJv1pWx")
                    .header("content-type", "application/json")
                    .header("Origin", "https://chat.deepseek.com")
                    .header("Connection", "keep-alive")
                    .header("Referer", "https://chat.deepseek.com/")
                    .header("Cookie", ".thumbcache_6b2e5483f9d858d7c661c5e276b6a6ae=NiRFURXg4/Dq4ym8x6SxJon0Z/LKzSMfICM8wJhcsxQwTyFOkaz44Kqbk7cFtpihWr6ZdoD+UwANtLIOHfsBqQ%3D%3D; smidV2=202505271015208fa7a3d358c7cfa2de44e7260a4f2755009e5b68921bc12d0; intercom-session-guh50jw4=QTZVZ0lwenhwcWpDZERmZ2FEeHREa2ExVUV1a0ZscFRrM0ZPZ3Qxa2t4RUxkTXNlRGxlQWtVRjFIZDN2dlA3Z3l6ZUtXYjUrV0EySDVTL1R1T0l1bjJzT1BOQnhqNDF4aU9jSEFTNkhlcHM9LS1abFgzR21xZ2dHSk9EQVdWQUl6L1d3PT0=--fd6d9eee7adefc0fdf33f8ddb88971b08a456b78; intercom-device-id-guh50jw4=9a698c8c-7fc8-4f6e-9e51-a788901bc542; HWWAFSESID=1449c52303ee0d43609; HWWAFSESTIME=1749258666691; ds_session_id=578fbae9300b45e390ff01fcc644598d")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Site", "same-origin")
                    .header("Priority", "u=0")
                    .header("TE", "trailers");

            // 发送请求并获取响应
            HttpResponse response = request.execute();
            log.info("响应数据: {}", response.body());

        });






    }
}
