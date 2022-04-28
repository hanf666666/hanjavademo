package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
  * 订单状态对应欠费补缴状态枚举
  * @author tianhf
  * @date 2019/10/22
  */
@Getter
@AllArgsConstructor
public enum OrderStatusToArrearsStatusEnum {

    /**
     * 5 未补缴， 6 已补缴  95 已清除
     */
    PAY_BACK(95, "已补缴"),
    AFTER_PAY_DODGING_TOLL(94, "部分已缴"),
    NOT_PAY_BACK(5, "未补缴"),
    CLEARED(6, "已清除");

    /**
     * 订单状态
     */
    private Integer value;


    /**
     * 欠费补缴状态 名称
     */
    private String name;

    /**
     * 根据枚举码获取枚举
     * @param value 枚举码
     * @return 枚举
     */
    public static String getNameByValue(Integer value) {
        if(Objects.isNull(value)){
            return "";
        }
        for (OrderStatusToArrearsStatusEnum item : OrderStatusToArrearsStatusEnum.values()) {
            if (item.getValue().equals(value)) {
                return item.getName();
            }
        }
        return "";
    }
}
