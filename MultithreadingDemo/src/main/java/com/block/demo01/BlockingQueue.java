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
            System.out.println("�����߳�����");
            wait();

        }

        if (this.queue.size() == 0) {
            System.out.println("�����̻߳���");
            notifyAll();

        }

        this.queue.add(item);

    }

    public synchronized Object dequeue()

            throws InterruptedException {

        while (this.queue.size() == 0) {
            System.out.println("�����߳�������");
            wait();
            System.out.println("�����˾Ͳ�ִ����,���ǻ���");

        }

        if (this.queue.size() == this.limit) {

            notifyAll();
            System.out.println("�����̻߳���");

        }

        return this.queue.remove(0);

    }

}