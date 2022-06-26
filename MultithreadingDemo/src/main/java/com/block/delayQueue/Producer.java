package com.block.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * to do
 *
 * @author Hj
 * @date 2022/6/7
 */
public class Producer {

    public static void main(String[] args) {
        DelayQueue<Message> queue = new DelayQueue<>();

        // ��ʱ5��
        Message m1 = new Message("��dei�Է�����", 5000);

        // ��ʱ15��
        Message m2 = new Message("�����𣿣�������������", 15000);

        // ����ʱ��Ϣ�ŵ���ʱ����
        queue.add(m1);
        queue.offer(m2);

        new Thread(new Consumer(queue)).start();

    }
}