package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test2;

import com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test1.Context;
import com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ.test1.GreenPen;

/**
 * ʹ�� if...else �������ĸ��Ӻ�����ά����
 * ������д��
 */
public class MainClass {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext();
        strategyContext.operate(2);
    }
}
