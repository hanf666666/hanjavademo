package com.date.DesignPattern.行为型模式.策略模式.test3;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public enum PayTypeEnum {
    NONE(-1, "不存在"),
    APP(0, "App支付"),
    PUB_MEM(10, "公众号支付"),
    H5(20, "H5支付"),
    CASH(30, "现金支付"),
    NO_SENSE(40, "无感支付"),
    SCAN_QR_CODE(50,"扫码支付"),
    CARD_PAY(60,"刷卡支付"),
    MINI_PROGRAM(70, "小程序支付");


    private Integer type;
    private String name;
    PayTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

}
