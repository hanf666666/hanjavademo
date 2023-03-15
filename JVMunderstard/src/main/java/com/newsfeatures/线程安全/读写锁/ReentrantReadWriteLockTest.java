package com.newsfeatures.�̰߳�ȫ.��д��;

import cn.hutool.core.date.DateUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    static class MyObject {
        private Object object;
        private ReadWriteLock lock = new ReentrantReadWriteLock();

        public void get() {
            //����
            lock.readLock().lock();
            System.out.println(DateUtil.date()+ Thread.currentThread().getName() + "׼��������!!");
            try {
                Thread.sleep(new Random().nextInt(10000));
                System.out.println(DateUtil.date()+ Thread.currentThread().getName() + "������Ϊ:" + this.object);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }

        public void put(Object object) {
            //д��
            lock.writeLock().lock();
            System.out.println(DateUtil.date()+ Thread.currentThread().getName() + "׼��д����");

            try {
                Thread.sleep(new Random().nextInt(10000));
                this.object = object;
                System.out.println(DateUtil.date()+ Thread.currentThread().getName() + "д����Ϊ" + this.object);
                System.out.println();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        final MyObject myObject = new MyObject();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1; j++)
                        myObject.put(new Random().nextInt(1000));
                }
            });
        }

        for (int i = 0; i < 1; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++)
                        myObject.get();
                }
            });
        }
        executor.shutdown();
    }
}
