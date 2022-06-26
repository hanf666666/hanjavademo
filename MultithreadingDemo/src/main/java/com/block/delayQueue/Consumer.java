package com.block.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * to do
 *
 * @author Hj
 * @date 2022/6/7
 */
public class Consumer implements Runnable {

    // ��ʱ����
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = queue.take();
                System.out.println("���յ���Ϣ���ݣ�" + message.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // getter/setter
}
