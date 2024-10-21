package com.list.ModificationException;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * to do
 *
 * @author Hj
 * @date 2024/10/18
 */
@Slf4j
public class demo02 {
    public static void main(String[] args) throws InterruptedException {

        Student student = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
//        ConcurrentLinkedDeque list = new ConcurrentLinkedDeque<>();
//        ConcurrentLinkedDeque list2 = new ConcurrentLinkedDeque<>();

        List list = new ArrayList<>();
        List list2 = new ArrayList<>();


        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            try {

                log.info("student--删除之前-->{}", list);
                list2.add(student);
                list2.add(student2);
                list2.add(student4);
                list.removeAll(list2);
                log.info("student--删除之后-->{}", list);
                countDownLatch.countDown();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {

                list.add(student);
                list.add(student2);
                countDownLatch.await();
                list.add(student3);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread.sleep(100000);


    }


}
