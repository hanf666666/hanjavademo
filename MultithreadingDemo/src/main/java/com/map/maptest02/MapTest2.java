package com.map.maptest02;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapTest
 * @Description HashMap�̰߳�ȫ������
 * @Author �񱼤���ţrz
 * @Date 2021/8/2
 */
public class MapTest2 {

    public static void main(String[] args) {

        //����һ��HashMap����
//        Map<String,String> map = new HashMap<>();
        //������: ʹ��ConcurrentHashMap
        Map<String,String> map = new ConcurrentHashMap<>();

        //��ѭ��ģ����̻߳���
        for (int i = 0; i < 30; i++) {
            //�����߳�
            new Thread(()->{
                //��map�з���ֵ: key����Ӧ��ǰ�̵߳�����, valueֵ��Ӧ�������д�0��5������ַ���
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                //��ӡmap����
                System.out.println(map);
                //��ȡ�������±�iλ�õ��ַ���, ���������߳�
            },String.valueOf(i)).start();
        }
    }

}
