package com.enums;

/**
 * to do
 *
 * @author Hj
 * @date 2022/4/25
 */
public class MainDemo {
    public static void main(String[] args) {
//        PAY_BACK(95, "已补缴"),
//                AFTER_PAY_DODGING_TOLL(94, "部分已缴"),
//                NOT_PAY_BACK(5, "未补缴"),
//                CLEARED(6, "已清除");
        System.out.println(OrderStatusToArrearsStatusEnum.getNameByValue(95));
    }
}
