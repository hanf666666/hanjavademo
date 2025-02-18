package com.http;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/25
 */
@Slf4j
public class hutoolDemo2 {
    public static void main(String[] args) {

        List<String> integers = new ArrayList<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        int threadNumber = 2000;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);//参数为线程个数

        for (int i = 0; i < 2000; i++) {

            AtomicInteger atomicInteger = new AtomicInteger(i);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    HashMap<String, Object> paramMap = new HashMap<>();

                    paramMap.put("beginNum", "1");
                    paramMap.put("endNum", "40");
                    paramMap.put("beginDate", DateUtil.date().toString("yyyy-MM-dd"));
                    paramMap.put("endDate", DateUtil.date().toString("yyyy-MM-dd"));
                    paramMap.put("hrmId", atomicInteger.get());
                    String result = HttpUtil.post("http://oa.dongyinghk.com:8000/custom/hrm/action/gethrmschedule.jsp", paramMap);
//                    System.out.println(result);
                    JSONObject jsonObject = JSONUtil.parseObj(result);
                    try {
                        List<OABean> result1 = BeanUtil.copyToList(jsonObject.getJSONArray("datas"), OABean.class);
                        OABean oaBean = result1.get(0);
                        integers.add(oaBean.getHrmid() + "\t" + oaBean.getHrmname());
//                        log.info("result1-->{}", result1);
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        countDownLatch.countDown();
//                        e.printStackTrace();
                    }
                }
            });


        }
        //线程启动后调用countDownLatch方法
        try {
            //需要捕获异常，当其中线程数为0时这里才会继续运行
            countDownLatch.await();
            System.out.println("=====================");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        integers.forEach(row -> {
            log.info("row-->{}", row);
        });


    }
}
