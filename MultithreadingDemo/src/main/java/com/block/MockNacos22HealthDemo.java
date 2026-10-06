package com.block;

/**
 * @author Hj
 * @date 2026/10/6
 */
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 模拟 Nacos?client 2.2.x RpcClient 健康检查模型
 * 关键点：BlockingQueue.poll + while循环，空闲才探测，有流量就跳过
 */
@Slf4j
public class MockNacos22HealthDemo {

    // 重连信号队列，对应源码 reconnectionSignal
    private final BlockingQueue<ReconnectSignal> reconnectSignal = new ArrayBlockingQueue<>(1);

    // 最后活跃时间戳，对应 lastActiveTimeStamp
    private volatile long lastActiveTimeStamp;

    // 连接是否健康标记
    private volatile AtomicBoolean connectionHealth = new AtomicBoolean(true);

    // keepAlive 超时时间，模拟 connectionKeepAlive 默认5秒
    private static final long CONNECTION_KEEP_ALIVE = 5000;

    public MockNacos22HealthDemo() {
        lastActiveTimeStamp = System.currentTimeMillis();
    }

    /**
     * 模拟收到业务请求，更新活跃时间戳
     * 只要有业务，就刷新这个值，会跳过健康探测
     */
    public void markActive() {
        lastActiveTimeStamp = System.currentTimeMillis();
        log.info("[" + System.currentTimeMillis() + "] >>> 收到业务流量，更新lastActiveTimeStamp");
    }

    /**
     * 模拟健康检查：发HealthCheckRequest
     */
    private boolean healthCheck() {
        log.info("[" + System.currentTimeMillis() + "] ------> 执行健康探测 healthCheck()");
        // 这里模拟：50%概率探测失败
        if (Math.random() > 0.5) {
            return true;
        } else {
            log.info("健康探测失败！");
            return false;
        }
    }

    /**
     * 模拟重连逻辑，切换服务节点
     */
    private void reconnect() {
        log.info("!!!!!!!!!! 执行重连、切换节点 !!!!!!!!!!\n");
        // 重连成功后恢复状态
        connectionHealth.set(true);
        markActive();
    }

    /**
     * 启动事件循环线程，复刻 RpcClient.start() 里面第二个 while 任务
     */
    public void start() {
        Thread eventThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    log.info("开始执行事件循环1");
                    // poll：最多阻塞等待 CONNECTION_KEEP_ALIVE 毫秒
                    ReconnectSignal signal = reconnectSignal.poll(CONNECTION_KEEP_ALIVE, TimeUnit.MILLISECONDS);
                    log.info("开始执行事件循环2");
                    if (signal == null) {
                        // poll超时，没有收到重连信号
                        long now = System.currentTimeMillis();
                        // 判断：是否空闲超时
                        if (now - lastActiveTimeStamp >= CONNECTION_KEEP_ALIVE) {
                            log.info("空闲超时，需要执行健康检测");
                            boolean healthy = healthCheck();
                            if (!healthy) {
                                // 探测失败，构造信号，下一轮循环执行重连
                                reconnectSignal.offer(new ReconnectSignal());
                                connectionHealth.set(false);
                            } else {
                                // 探测成功，更新活跃时间
                                markActive();
                            }
                        } else {
                            // 还没空闲，有业务流量，直接跳过健康检查！【2.2核心特征】
                            // log.info("链路还活跃，跳过本次健康探测");
                        }
                        continue;
                    }

                    // 拿到重连信号，执行重连
                    reconnect();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        eventThread.setDaemon(true);
        eventThread.setName("mock?rpc?event?worker");
        eventThread.start();
        log.info("模拟2.2事件循环线程已启动\n");
    }

    /**
     * 外部主动触发重连（对应 switchServerAsync）
     */
    public void triggerReconnect() {
        reconnectSignal.offer(new ReconnectSignal());
    }

    static class ReconnectSignal {
    }


    // 测试主方法
    public static void main(String[] args) throws InterruptedException {
        MockNacos22HealthDemo demo = new MockNacos22HealthDemo();
        demo.start();

        // 场景1：持续模拟业务流量，不断 markActive
        log.info("===== 场景1：持续业务流量 12秒 =====");
        for (int i = 0; i < 4; i++) {
            Thread.sleep(3000);
            demo.markActive();
        }

        // 场景2：不再有业务，空闲，观察会不会触发健康探测
        log.info("\n===== 场景2：不再产生业务流量，进入空闲 =====");
        Thread.sleep(15000);

        // 场景3：外部主动发送重连信号
        log.info("\n===== 场景3：外部主动触发重连信号 =====");
        demo.triggerReconnect();

        Thread.sleep(8000);
        log.info("demo结束");
    }
}

