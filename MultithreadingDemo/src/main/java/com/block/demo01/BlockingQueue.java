package com.block.demo01;
import java.util.LinkedList;

import java.util.List;
/**
 * to do
 *
 * @author Hj
 * @date 2022/2/9
 */
public class BlockingQueue {

    private List queue = new LinkedList();

    private int limit = 10;

    public BlockingQueue(int limit) {

        this.limit = limit;

    }

    public synchronized void enqueue(Object item)

            throws InterruptedException {

        while (this.queue.size() == this.limit) {
            System.out.println("生产线程阻塞");
            wait();

        }

        if (this.queue.size() == 0) {
            System.out.println("生产线程唤醒");
            notifyAll();

        }

        this.queue.add(item);

    }

    public synchronized Object dequeue()

            throws InterruptedException {

        while (this.queue.size() == 0) {
            System.out.println("消费线程阻塞了");
            wait();
            System.out.println("阻塞了就不执行了,除非唤醒");

        }

        if (this.queue.size() == this.limit) {

            notifyAll();
            System.out.println("消费线程唤醒");

        }

        return this.queue.remove(0);

    }

}