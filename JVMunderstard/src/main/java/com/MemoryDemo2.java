package com;

import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2022/6/26
 */
public class MemoryDemo2 {
    public static void main(String[] args) {
        String hanjing = "1a����";
        System.out.println(hanjing.getBytes().length);
        Long m=1*1024*1024L;
        System.out.println(m);
        System.out.println(1000000000*11L);
        System.out.println("=======��������ռ���ܵĴ�С=======================================>");
        //��ô���ֽڻ���Ϊm
        System.out.println("��������ռ���ܵĴ�С"+(1000000000*11L)/m+"M");
        System.out.println("<=======��������ռ���ܵĴ�С=======================================");

        System.out.println("=======�������ڴ��С��������e4����1��=======================================>");
        //�ܵ�����ռ�ô�С
        Long totalMomey=12*m*1024L;
        System.out.println("�������ڴ��С��������"+(12.41*1024*1024*1024L)/400+"������");
        System.out.println("<=======�������ڴ��С��������=======================================");

        System.out.println("=======�������ڴ��С����ÿ�������ֽ�=======================================>");
        //�ܵ�����ռ�ô�С ��λ�ֽ�
        Long totalMomey2=2*m*1024L;
        Long rows=5000000L;
        System.out.println("�������ڴ��С����ÿ��"+(totalMomey2)/rows+"�ֽ�");
        System.out.println("<=======�������ڴ��С����ÿ�������ֽ�=======================================");


        System.out.println("=======mysql B+ 3������� һ��pageһ��io=======================================>");
        //�ܵ�����ռ�ô�С ��λ�ֽ�
        Long rowsbates=322L;

        System.out.println("mysql B+ 3�������"+(1170*1170)*((16*1024)/rowsbates)+"��");
        System.out.println("<=======mysql B+ 3������� һ��pageһ��io=======================================");

        new ArrayList<>();



//        ��ֵ���洢����
        System.out.println(calculate(8*4-1L));


    }
    private static Long calculate(Long n) {
        if (n == 0)
            return 1L;
        return 2L * calculate(n - 1);
    }

}
