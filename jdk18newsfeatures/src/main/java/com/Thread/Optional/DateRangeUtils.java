package com.Thread.Optional;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
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
public class DateRangeUtils {
    private DateTime starttime = null;
    private DateTime endtime = null;

    public DateRangeUtils() {
        this.starttime = DateUtil.date();
        ;
    }

    public void setStartTime() {

    }

    public void printDateDiff(List list, String meissage) {
        endtime = DateUtil.date();
        final Optional<List> listOptional = Optional.ofNullable(list);

//        log.info("{}==>数据有多少{}条,响应时间==>{}ms", meissage, listOptional.map(l -> l.size()).orElseGet(() -> null), DateUtil.between(starttime, endtime, DateUnit.MS));
    }
}
