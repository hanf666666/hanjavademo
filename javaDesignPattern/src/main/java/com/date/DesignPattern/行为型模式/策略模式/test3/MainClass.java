package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test3;

import com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test3.StrategyContext;

/**
 * ʹ�� if...else �������ĸ��Ӻ�����ά����+hashMap
 * �������Ǵ���,������С��
 * ֧����֧����΢��֧���ٿ���дһ���� �����ٴγ����µĲ�������
 */
public class MainClass {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext();
        String pay = strategyContext.pay(PayTypeEnum.H5);
        System.out.println(pay);
    }
}
