package com.http.baidu;

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
public class baiduhttp {
    public static void main(String[] args) {
        // 创建一个 HttpRequest 对象
        String url = "https://chat.baidu.com/csaitab/history/delete";
        FileReader fileReader = new FileReader("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\src\\main\\java\\com\\http\\baidu\\data.json");
        String result = fileReader.readString();
        System.out.println(result);
        JSONArray jsonArray = JSONUtil.parseObj(result).getJSONObject("data").getJSONArray("historyData");
        jsonArray.stream().forEach(row->{
            JSONObject jsonObject = (JSONObject) row;
            String ori_lid = jsonObject.getStr("sessionId");
            HttpRequest request = HttpRequest.post(url).body("{\"req_type\":1,\"ori_lid_list\":[{\"ori_lid\":\""+ori_lid+"\"}]}")
                    .header("https", "/chat.baidu.com/csaitab/history/delete")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0")
                    .header("Accept", "*/*")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                    .header("Accept-Encoding", "gzip, deflate, br, zstd")
                    .header("Content-Type", "text/plain;charset=UTF-8")
                    .header("Referer", "https://chat.baidu.com/aichat/history")
                    .header("Origin", "https://chat.baidu.com")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Site", "same-origin")
                    .header("Connection", "keep-alive")
                    .header("Cookie", "BAIDUID=C53A3A8527B1A11FBC4F4AD2E49AABD3:SL=0:NR=10:FG=1; BIDUPSID=C53A3A8527B1A11FCE6561DE835B137F; PSTM=1747788992; H_PS_PSSID=62325_63145_63210_63243_63269_63326_63389_63380_63391_63404_63442; BDUSS=lI1M1V0SW5NN2MwR0RpVXBHfjJPR3kwaFMwWkhwSURqV284QzFPQlJZbllzVlJvSVFBQUFBJCQAAAAAAAAAAAEAAADLEvpS17fW8NXfNjY2NjY2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANgkLWjYJC1oT; H_WISE_SIDS=62325_63145_63210_63243_63269_63326_63389_63380_63391_63404_63442; MCITY=-330%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; PSINO=6; BDRCVFR[feWj1Vr5u3D]=mk3SLVN4HKm; BA_HECTOR=21ak00al2h8084850h2k2000ah252g1k4307425; ZFY=NBLohc9hFwNgUh01m2Sa:AMu4BdpOJ29JfJdBrOIg7xQ:C")
                    .header("Priority", "u=0");

            // 发送请求并获取响应
            HttpResponse response = request.execute();
            log.info("响应数据: {}", response.body());

        });






    }
}
