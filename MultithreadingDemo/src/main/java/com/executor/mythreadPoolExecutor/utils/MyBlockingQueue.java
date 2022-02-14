package com.executor.mythreadPoolExecutor.utils;

import com.yxkj.instance.Queue1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/13
 */
public class MyBlockingQueue implements BlockingQueue<Runnable> {
    private final ReentrantLock lock = new ReentrantLock();
    //�������
    private final LinkedList<Runnable> queue = new LinkedList<>();
    private int size;
    private long timeOut;

    /**
     * �յ���������
     */
    private final Condition empty;

    /**
     * ������������
     */
    private final Condition full;


    /**
     * ���췽��
     *
     * @param capacity
     * @param keepAliveTime
     * @param unit
     */
    public MyBlockingQueue(int capacity, long keepAliveTime,
                         TimeUnit unit) {
        this.size = capacity;
        empty = lock.newCondition();
        full = lock.newCondition();
        this.timeOut = unit.toNanos(keepAliveTime);//��ʱʱ��
    }

    @Override
    public boolean add(Runnable runnable) {
        return false;
    }

    /**
     * ��һ������
     *
     * @param run
     * @return
     */
    @Override
    public boolean offer(Runnable run) {
        if (run == null) {
            throw new NullPointerException();
        }

        lock.lock();
        try {
            long n = timeOut;
            //����������˯�ߵȴ�
            while (size == queue.size()) {
                if (n <= 0) {
                    //��ʱ�����ʧ��
                    return false;
                }
                //�����û��ʱ�������˯��
                n = full.awaitNanos(n);
            }

            queue.addLast(run);
            //����һ���̸߳��������ԴӶ�������ȡ������
            empty.signal();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

    @Override
    public Runnable remove() {
        return null;
    }

    @Override
    public void put(Runnable runnable) throws InterruptedException {

    }

    @Override
    public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Runnable take() throws InterruptedException {
        return null;
    }

    @Override
    public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Runnable> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Runnable> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c, int maxElements) {
        return 0;
    }

    /**
     * ȡһ������
     *
     * @return
     */
    @Override
    public Runnable poll() {
        lock.lock();

        try {
            long n = timeOut;
            while (queue.isEmpty()) {
                if (n <= 0) {
                    //��ʱ�򷵻�null������null�����߳̾ͻᱻ���յ�
                    return null;
                }
                System.out.println(Thread.currentThread().getName() + "����Ϊ�գ�˯�ߵȴ�");
                //�����û��ʱ�������˯��
                n = empty.awaitNanos(n);
            }

            //ȡ��һ�����񷵻�ִ��
            Runnable task = queue.removeFirst();
            //����һ���̣߳������������������������
            full.signal();
            return task;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return null;
    }

    @Override
    public Runnable element() {
        return null;
    }

    @Override
    public Runnable peek() {
        return null;
    }

    /**
     * ���еĴ�С
     *
     * @return
     */
    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
