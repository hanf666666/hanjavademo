package com.completableFuture;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 异步编排
 */
@Slf4j
public class OrderCompletableFutureDemo {

    // 自定义线程池，避免使用默认的 ForkJoinPool
    private static final ExecutorService POOL = Executors.newFixedThreadPool(2);

    // 模拟业务上下文
    static class OrderContext {
        Long userId;
        String userLevel;
        Double discount;
        String orderId;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        OrderContext ctx = new OrderContext();

        // 1. 无依赖任务：加载用户信息和校验库存可并行
        CompletableFuture<Void> loadUser = CompletableFuture.runAsync(() -> {
            sleep(100);
            ctx.userId = 1001L;
            ctx.userLevel = "VIP";
            log.info(" 1线 1[100加载用户信息] userId=" + ctx.userId);
        }, POOL);


        // 2. 计算优惠依赖「加载用户信息」  1
        CompletableFuture<Void> calcDiscount = loadUser.thenRunAsync(() -> {
            sleep(200);
            ctx.discount = "VIP".equals(ctx.userLevel) ? 0.8 : 1.0;
            log.info(" 1线 2[200计算优惠] 折扣= " + ctx.discount);
        }, POOL);


        CompletableFuture<Void> checkStock = CompletableFuture.runAsync(() -> {
            sleep(100);
            log.info(" 2线 1[100校验库存] 库存充足");
        }, POOL);
        // 3. 锁定库存依赖「校验库存」和「计算优惠」全部完成
        //    thenCombine 将两个 Future 的结果合并
        CompletableFuture<Void> lockStock = checkStock
                .thenCombine(calcDiscount, (v1, v2) -> {
                    sleep(200);
                    System.out.println("3线  1[200锁定库存] 完成");
                    return null;
                });

        // 4. 创建订单依赖「锁定库存」
        CompletableFuture<Void> createOrder = lockStock.thenRunAsync(() -> {
            sleep(1000);
            ctx.orderId = "ORD" + System.currentTimeMillis();
            log.info("  4线 3[1000创建订单] orderId=" + ctx.orderId);
        }, POOL);

        // 5. 发送通知依赖「创建订单」
        CompletableFuture<Void> sendNotification = createOrder.thenRunAsync(() -> {
            sleep(1000);
            log.info("  5线 4[1000发送通知] orderId=" + ctx.orderId);
        }, POOL);

        // 6. 等待整个链路完成
        sendNotification.get(10, TimeUnit.SECONDS);

        long cost = System.currentTimeMillis() - start;
        System.out.println();
        log.info("==================== CompletableFuture 编排报告 ====================");
        log.info("整体结果: 成功, 总耗时: " + cost + " ms");
        System.out.println("==================================================================");

        POOL.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
