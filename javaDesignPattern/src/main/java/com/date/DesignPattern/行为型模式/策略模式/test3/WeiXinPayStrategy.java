package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test3;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public interface WeiXinPayStrategy {
    //΢������֧��
    String NO_SENSE();

    //H5Pay
    String H5Pay();

    //SCAN_QR_CODE ɨ��
    String SCAN_QR_CODE();

    //��֧��
    String CARD_PAY();



}
