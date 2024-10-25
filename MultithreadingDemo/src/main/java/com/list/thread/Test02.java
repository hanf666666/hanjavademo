package com.list.thread;

import cn.hutool.core.collection.ListUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ArrayList���̲߳���ȫ��,put���ڶ��̻߳ᶪʧ
 *
 * @author Hj
 * @date 2024/7/23
 */
@Slf4j
public class Test02 {
    public static void main(String[] args) {

        List<Future> futureList = new ArrayList<>();
        List<Long> synlist = Collections.synchronizedList(new ArrayList<>());
//        List<Long> synlist = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                Long i = 0L;
                while (true) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    i = i + 1;
                    synlist.add(i);
//                    log.info("i ����= {}", i);
                }


            }
        });

        Future<?> submit2 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
//                        Thread.sleep(5000);
//                        synlist.removeAll(synlist);
                        if(synlist.size() < 100) {
                            continue;
                        }
                        System.out.println();
                        synchronized (synlist) {
//                           ���ȼ���
                            List<Long> newSynlist=ListUtil.toList(synlist);

//                            List<Long> newSynlist = new ArrayList<>();
//                            newSynlist.addAll(synlist);

                            //ͬһ��list�Ĵ���ɾ����䵼�²�׼ȷ
                            List<List<Long>> partition = ListUtil.partition(newSynlist, 2);
                            log.info("synlist.size()->{},partition1.size() = {}", synlist.size() ,partition.size());
                            int count = 0;
                            int size=partition.size();
                            for (int i = 0; i < size; i++) {
                                synlist.removeAll(partition.get(i));
                                count++;
//                                log.info("synlist.size() = {}", synlist.size());
                            }
                            log.info("synlist.size()->{},partition2.size() = {},-->count = {}", synlist.size() ,partition.size(),count);

                        }

                        //synlist.iterator();���ֶ�����
//                       synchronized (synlist) {
//                           Iterator<Long> iterator = synlist.iterator();
//                           while (iterator.hasNext()) {
//                               Long next = iterator.next();
////                            log.info("next �Ƴ�= {}", next);
//                               iterator.remove();
//
//                           }
//                       }

                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }


            }
        });

        futureList.add(submit);
        futureList.add(submit2);

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });


    }
}
