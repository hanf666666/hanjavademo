package com.date.DesignPattern.行为型模式.策略模式.test3;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public interface WeiXinPayStrategy {
    //微信免密支付
    String NO_SENSE();

    //H5Pay
    String H5Pay();

    //SCAN_QR_CODE 扫码
    String SCAN_QR_CODE();

    //卡支付
    String CARD_PAY();



}
