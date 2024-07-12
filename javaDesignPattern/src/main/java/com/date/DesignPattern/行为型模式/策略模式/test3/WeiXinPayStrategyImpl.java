package com.date.DesignPattern.行为型模式.策略模式.test3;

import com.date.DesignPattern.行为型模式.策略模式.test2.Strategy;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public class WeiXinPayStrategyImpl implements WeiXinPayStrategy {


    @Override
    public String NO_SENSE() {
        return "微信免密支付";
    }

    @Override
    public String H5Pay() {
        return "H5Pay";
    }

    @Override
    public String SCAN_QR_CODE() {
        return "SCAN_QR_CODE 扫码";
    }

    @Override
    public String CARD_PAY() {
        return "卡支付";
    }
}
