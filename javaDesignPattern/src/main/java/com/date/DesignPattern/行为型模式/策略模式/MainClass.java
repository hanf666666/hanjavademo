package com.date.DesignPattern.��Ϊ��ģʽ.����ģʽ;

/**
 * ʹ�� if...else �������ĸ��Ӻ�����ά����
 */
public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new GreenPen()); // ʹ����ɫ������
        context.executeDraw(10, 0, 0);
    }
}
