package com.block.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * to do
 *
 * @author Hj
 * @date 2022/6/7
 */
public class Consumer implements Runnable {

    // 延时队列
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = queue.take();
                System.out.println("接收到消息内容：" + message.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // getter/setter
}
