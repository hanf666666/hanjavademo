package com;

/**
 * @author Hj
 * @date 2026/8/13
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 示例：模拟停车场，只有 3 个车位，5 辆车抢着停
 *
 * 特性	      CountDownLatch	            Semaphore
 * 核心机制	  计数器减到0才放行	        管理许可证，有证才能执行
 * 主要用途	  等待多个事件完成	        控制同时访问的线程数
 * 是否可复用   否，计数归零后失效       	是，许可证可循环使用
 * 典型场景	主线程等待所有子任务结束	限流、连接池、资源池控制
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 1. 创建信号量，许可证数量 = 3（代表 3 个车位）
        Semaphore parkingSpots = new Semaphore(3);

        // 2. 模拟 5 辆车
        for (int i = 1; i <= 5; i++) {
            int carNo = i;
            new Thread(() -> {
                try {
                    // 尝试获取车位（获取许可证）
                    System.out.println("? 车辆 " + carNo + " 到达，尝试找车位...");

                    // 尝试等待 3 秒，如果 3 秒内没有车位就不等了（非阻塞式）
                    // 也可以直接用 parkingSpots.acquire(); 一直等到有车位为止
                    if (parkingSpots.tryAcquire(3, TimeUnit.SECONDS)) {
                        // 获取成功，停车
                        System.out.println("? 车辆 " + carNo + " 成功停车，剩余车位: "
                                + parkingSpots.availablePermits());

                        // 模拟停车时间（2-5 秒不等）
                        int parkTime = (int) (Math.random() * 4 + 2);
                        Thread.sleep(parkTime * 1000L);

                        System.out.println("? 车辆 " + carNo + " 停放了 " + parkTime
                                + " 秒后离开，释放车位");

                        // 释放车位（释放许可证）
                        parkingSpots.release();
                        System.out.println("? 当前可用车位: " + parkingSpots.availablePermits());

                    } else {
                        // 等待超时，没拿到车位
                        System.out.println("? 车辆 " + carNo + " 等待超时，放弃了");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            // 车辆稍微错开一点到达时间，模拟真实场景
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}