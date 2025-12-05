package com.completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author Hj
 * @date 2025/12/4
 */
public class WhenCompleteDemo {
    public static void main(String[] args) {
        System.out.println("-----main start--------"+Thread.currentThread().getId());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int a = 10 / 2;
            System.out.println("当前线程"+Thread.currentThread().getId()+"------当前结果" + a);
            return a;
        }).whenComplete((result,exception)->{
            System.out.println("异步任务完成了，结果："+result);
            System.out.println("异步任务异常："+exception);
        });
    }
}
