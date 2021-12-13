package com.Thread.������.����ģʽ.����ģʽ;

import java.util.Date;

//������
public class Singleton  {
    //���þͻᴴ��
    private Singleton(){
        System.out.println("����ģʽ");
    }
    private static Singleton instance=  new Singleton();
    public static Singleton getInstance() {
        return instance;
    }

    // Ϲдһ����̬������������˵���ǣ��������ֻ��Ҫ���� Singleton.getDate(...)��
    // �����ǲ���Ҫ���� Singleton ʵ���ģ�����û�취���Ѿ�������
    public static Date getDate(String mode) {

        System.out.println("getDate");
        return new Date();}

}
