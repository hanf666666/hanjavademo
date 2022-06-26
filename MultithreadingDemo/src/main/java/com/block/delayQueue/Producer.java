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

        // 延时5秒
        Message m1 = new Message("兄dei吃饭了吗？", 5000);

        // 延时15秒
        Message m2 = new Message("开黑吗？？？我玩亚索！", 15000);

        // 将延时消息放到延时队列
        queue.add(m1);
        queue.offer(m2);

        new Thread(new Consumer(queue)).start();

    }
}