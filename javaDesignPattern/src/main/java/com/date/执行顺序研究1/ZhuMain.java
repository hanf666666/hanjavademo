package com.date.ִ��˳���о�1;

/**
 * ��̬����鳬������
 * �����������ȹ���
 * ��̬��������,�������ԭ��
 * ��ͨ��������,�������ԭ��
 */
public class ZhuMain {
    public static void main(String[] args) {
        System.out.println("=========  Fua Fua = new Zib();======================================");
        Zib zib = new Zib();
        zib.ziName = "zib";
        Fua a = zib;
        String ziName = ((Zib) a).ziName;

        a.statica1();
        a.a2();
        System.out.println("=========  Zib Zib= new Zib();======================================");
        Zib b= new Zib();
        b.statica1();
        b.a2();
    }
}

