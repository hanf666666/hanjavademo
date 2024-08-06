package com.cache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.EnumUtil;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;

import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/24
 */
public class TimedCacheDemo {
    public static void main(String[] args) {
        Map<String,FillPatternTypeEnum> enumMap = EnumUtil.getEnumMap(FillPatternTypeEnum.class);


        TimedCache<String, String> subTopicCache = CacheUtil.newTimedCache(30000);
        subTopicCache.put("key", "value");
        subTopicCache.put("key2", "value2");
        subTopicCache.forEach((System.out::println));
        ThreadUtil.sleep(20000);
        subTopicCache.forEach((System.out::println));
        ThreadUtil.sleep(30000);
        subTopicCache.forEach((System.out::println));


    }
}
