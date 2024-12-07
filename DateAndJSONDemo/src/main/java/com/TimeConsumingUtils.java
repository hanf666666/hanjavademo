package com;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/11
 */
@Slf4j
public class TimeConsumingUtils {
    private Long starttime = null;
    private Long endtime = null;

    public TimeConsumingUtils() {
        this.starttime = System.currentTimeMillis();
    }

    public void setStartTime() {

    }


    public void printDateDiff(List list, String meissage) {
        endtime = System.currentTimeMillis();
        final Optional<List> listOptional = Optional.ofNullable(list);
        log.info("{}==>数据有多少{}条,耗时时间==>{}ms", meissage, listOptional.map(l -> l.size()).orElseGet(() -> null),endtime-starttime);
    }
}
