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
public class StreetDTO {

    @Alias("街道ID")
    private String streeId;
//    private String 街道ID;

    @Alias("街道名称")
    private String StreetName;
//    private String 街道名称;


}
