package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test3;

/**
 * to do
 *
 * @author Hj
 * @date 2024/7/12
 */
public enum PayTypeEnum {
    NONE(-1, "������"),
    APP(0, "App֧��"),
    PUB_MEM(10, "���ں�֧��"),
    H5(20, "H5֧��"),
    CASH(30, "�ֽ�֧��"),
    NO_SENSE(40, "�޸�֧��"),
    SCAN_QR_CODE(50,"ɨ��֧��"),
    CARD_PAY(60,"ˢ��֧��"),
    MINI_PROGRAM(70, "С����֧��");


    private Integer type;
    private String name;
    PayTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

}
