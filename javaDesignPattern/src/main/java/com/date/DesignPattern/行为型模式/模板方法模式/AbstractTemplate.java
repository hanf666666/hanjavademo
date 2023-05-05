package com.date.DesignPattern.��Ϊ��ģʽ.ģ�巽��ģʽ;

/**
 * to do
 *
 * @author Hj
 * @date 2023/5/5
 */
public abstract class AbstractTemplate {
    // �����ģ�巽��
    public void templateMethod(){
        init();
        apply(); // ������ص�
        end(); // ������Ϊ���ӷ���
    }
    protected void init() {
        System.out.println("init ������Ѿ�ʵ�֣�����Ҳ����ѡ��д");
    }
    // ��������ʵ��
    protected abstract void apply();
    protected void end() {
    }
}
