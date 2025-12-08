package com.base02.主线程等子线程.synchronized2;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 不太明白 Object能锁住
 */
public class demo2 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        BlockingQueue<String> busMsgBlockingQueue = new LinkedBlockingQueue<>();
        Map<String, PriorityBlockingQueue<String>> queueMap=new ConcurrentHashMap<>();
        Thread threaput = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    String data=String.valueOf(i);
                    PriorityBlockingQueue<String> priorityBlockingQueue = queueMap.computeIfAbsent("1",
                            k -> new PriorityBlockingQueue<>(11));

                    priorityBlockingQueue.add(data);
                    if(!busMsgBlockingQueue.contains(i)) {
                        try {
                            busMsgBlockingQueue.put(String.valueOf(i));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        });




        ThreadUtil.execute(() -> {
            while(true) {
                String currIdentifi = "";
                try {
                    String identifi = busMsgBlockingQueue.take();


                    currIdentifi = identifi;
                    handler(queueMap, identifi)    ;
                    //没有任务时 删除key

                } catch (Exception e) {

                } finally {
                    ThreadUtil.safeSleep(100);
                }
            }
        });


        Thread.sleep(1000000);


    }
    /**
     * 同步数据
     * @param queueMap
     * @param identifi
     */
    public static void handler(Map<String, PriorityBlockingQueue<String>> queueMap, String identifi) {
        PriorityBlockingQueue<String> identifiPriorityBlockingQueue = queueMap.get(identifi);
        String eventBusMsg = null;
        String remoteUrl = "";
        try {
            while(true) {
                if(identifiPriorityBlockingQueue == null) {
                    break;
                }
                eventBusMsg = identifiPriorityBlockingQueue.poll();
                if(eventBusMsg == null) {
                    break;
                }

                //调用远程接口
                String requestBody = JSONUtil.toJsonStr(eventBusMsg);


            }
        } catch (Exception e) {

        } finally {
            //从存在队列移除
        }
    }
}
