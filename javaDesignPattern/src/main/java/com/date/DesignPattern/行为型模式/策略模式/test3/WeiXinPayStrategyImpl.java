package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test3;

import com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test2.Strategy;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public class WeiXinPayStrategyImpl implements WeiXinPayStrategy {


    @Override
    public String NO_SENSE() {
        return "΢������֧��";
    }

    @Override
    public String H5Pay() {
        return "H5Pay";
    }

    @Override
    public String SCAN_QR_CODE() {
        return "SCAN_QR_CODE ɨ��";
    }

    @Override
    public String CARD_PAY() {
        return "��֧��";
    }
}
