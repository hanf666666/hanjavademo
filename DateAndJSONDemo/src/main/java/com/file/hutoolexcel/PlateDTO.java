package com.file.hutoolexcel;

import cn.hutool.core.annotation.Alias;
import lombok.Data;
import lombok.ToString;

/**
 * to do
 * 交通银行三方账单
 * @author Hj
 * @date 2022/12/30
 */
@Data
@ToString
public class PlateDTO {

//    @Alias("车牌")
//    private String plate;

    @Alias("开始时间")
    private String startTime;

    @Alias("截止时间")
    private String endTime;

}
