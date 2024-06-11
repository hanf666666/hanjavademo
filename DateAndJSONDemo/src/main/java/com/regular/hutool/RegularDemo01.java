package com.regular.hutool;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/11
 */
public class RegularDemo01 {
    public static void main(String[] args) {
        String content = "ZZZaaabbbccc中文1234";
        boolean isMatch = ReUtil.isMatch("\\w+[\u4E00-\u9FFF]+\\d+", content);
        System.out.println(isMatch);

        content = "ZZZaaabbbccc中文1234";
        List<String> resultFindAll = ReUtil.findAll("\\w{2}", content, 0, new ArrayList<>());
        System.out.println(resultFindAll);
// 结果：["ZZ", "Za", "aa", "bb", "bc", "cc", "12", "34"]


    }
}
