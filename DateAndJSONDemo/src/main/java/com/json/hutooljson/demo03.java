package com.json.hutooljson;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
@Slf4j
public class demo03 {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("11111");
        strings.add("22222");
        System.out.println(JSONObject.toJSONString("11111"));



        }


    }
