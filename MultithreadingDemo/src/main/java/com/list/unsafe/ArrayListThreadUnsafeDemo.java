package com.list.unsafe;

/**
 * to do
 * ���߳�д��õ����������ݲ�һ������
 * @author Hj
 * @date 2024/10/21
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListThreadUnsafeDemo {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
        //��ӵ�������������
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list =new CopyOnWriteArrayList<>();

        // ��������̣߳�ÿ���̶߳����б������Ԫ��
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    list.add(j); // ����û�н���ͬ������
                }
            }).start();
        }

        // Ϊ��ȷ�������̶߳�ִ����ϣ�����򵥵صȴ�һ��ʱ�䣨���Ƽ�������������ʹ�ã�
        try {
            Thread.sleep(5000); // �ȴ�5��
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ��ӡ�б��С��������Ӧ����100000��1000���̣߳�ÿ���߳����100��Ԫ�أ�
        // �������̲߳���ȫ��ʵ�ʴ�С���ܻ�С�����ֵ
        System.out.println("List size: " + list.size());

        // ��ӡ�б����ݣ����ܻᷢ���ظ���Ԫ�ػ�ȱʧ��Ԫ�أ�
        // System.out.println(list);
    }
}