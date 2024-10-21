package com.list.ModificationException;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/10/21
 */
@Slf4j
public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // ��ȡ������
        Iterator<String> iterator = list.iterator();

        // ʹ�õ����������б�
        while (iterator.hasNext()) {
            String item = iterator.next();
            list.add("D");
            // �ڱ��������У�ֱ��ͨ���б�����޸��б�������ͨ����������
            if (item.equals("B")) {
                List<String> list2 = new ArrayList<>();
                list2.add(item);
                list2.add("C");
                list.removeAll(list2);  // �⽫���� ConcurrentModificationException
            }
            log.info("list--->{}", list);
            System.out.println(item);
        }

        // ע�⣺��������Ĵ�����׳��쳣������Ĵ���ͨ�����ᱻִ��
        System.out.println("�������");
    }
}

