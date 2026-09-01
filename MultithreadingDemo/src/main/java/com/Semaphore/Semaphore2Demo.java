package com.Semaphore;

/**
 * @author Hj
 * @date 2026/8/13
 */
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**

 */
@Slf4j
public class Semaphore2Demo {

    public static void main(String[] args) {

        //每秒只发出5个令牌
        RateLimiter rateLimiter = RateLimiter.create(5.0);
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        // 2. 模拟 1111 辆车
        for (int i = 1; i <= 1111; i++) {
            int carNo = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 尝试等待 3 秒，如果 3 秒内没有车位就不等了（非阻塞式）
                        // 也可以直接用 parkingSpots.acquire(); 一直等到有车位为止
                        if (rateLimiter.tryAcquire(3, TimeUnit.SECONDS)) {
                            Thread.sleep(1);
                            log.info("车辆 {} 抢到车位，开始停车", carNo);

                        } else {
                            // 等待超时，没拿到车位
                            System.out.println(" 车辆 " + carNo + " 等待超时，放弃了");
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });


        }


        // 车辆稍微错开一点到达时间，模拟真实场景
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
