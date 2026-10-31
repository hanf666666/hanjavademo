package com.javaheap.demo03ThreadLocal;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SimpleDateFormat 的 calendar 是实例级共享状态，format/parse 都要读写它，多线程不加锁必然互相踩踏。
 * DateTimeFormatter
 */
public class SdfConcurrencyDemo {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final int THREADS = 8;
    private static final int LOOPS = 3000;

    // ? 罪魁祸首：全局共享一个实例
    private static final SimpleDateFormat SHARED = new SimpleDateFormat(PATTERN);

    // ? 正确姿势：每个线程一个
    private static final ThreadLocal<SimpleDateFormat> TL =
            ThreadLocal.withInitial(() -> new SimpleDateFormat(PATTERN));

    public static void main(String[] args) throws Exception {
        DateTime date = DateUtil.date();
        String dateStr = date.toDateStr();
        // 预生成基准数据：单线程算好，绝对正确，作为"标准答案"
        long base = 1_700_000_000_000L;
        Date[] dates = new Date[LOOPS];
        String[] expected = new String[LOOPS];
        SimpleDateFormat ref = new SimpleDateFormat(PATTERN);
        for (int i = 0; i < LOOPS; i++) {
            dates[i] = new Date(base + i * 1000L);
            expected[i] = ref.format(dates[i]);
        }

        System.out.println("========== 1. 共享 SimpleDateFormat（错误示范） ==========");
        run("共享版", () -> SHARED, dates, expected, ref);

        System.out.println();
        System.out.println("========== 2. ThreadLocal 版（正确姿势） ==========");
        run("ThreadLocal版", () -> TL.get(), dates, expected, ref);
    }

    interface SdfProvider {
        SimpleDateFormat get();
    }

    static void run(String name, SdfProvider provider,
                    Date[] dates, String[] expected, SimpleDateFormat ref) throws Exception {

        AtomicInteger formatErr = new AtomicInteger();  // format 输出错乱/异常
        AtomicInteger parseErr  = new AtomicInteger();  // parse 抛异常
        AtomicInteger parseWrong = new AtomicInteger(); // parse 结果错
        ConcurrentLinkedQueue<String> samples = new ConcurrentLinkedQueue<>();

        ExecutorService pool = Executors.newFixedThreadPool(THREADS);
        CountDownLatch start = new CountDownLatch(1);   // 同时起跑，拉满竞争
        CountDownLatch done  = new CountDownLatch(THREADS);

        for (int t = 0; t < THREADS; t++) {
            pool.submit(() -> {
                SimpleDateFormat sdf = provider.get();  // ThreadLocal 版每个线程拿到自己的
                try {
                    start.await();
                    for (int i = 0; i < LOOPS; i++) {
                        // ---- 1) format 校验 ----
                        try {
                            String got = sdf.format(dates[i]);
                            if (!got.equals(expected[i])) {
                                formatErr.incrementAndGet();
                                if (samples.size() < 6)
                                    samples.offer("format 错乱 | 期望 " + expected[i]
                                            + " 实际 " + got);
                            }
                        } catch (Exception e) {
                            formatErr.incrementAndGet();
                            if (samples.size() < 6)
                                samples.offer("format 异常 | " + e.getClass().getSimpleName());
                        }

                        // ---- 2) parse 校验 ----
                        try {
                            Date parsed = sdf.parse(expected[i]);
                            if (parsed == null || parsed.getTime() != dates[i].getTime()) {
                                parseWrong.incrementAndGet();
                                if (samples.size() < 6)
                                    samples.offer("parse 错值 | 期望 " + expected[i]
                                            + " 实际 " + (parsed == null ? "null" : ref.format(parsed)));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            parseErr.incrementAndGet();
                            if (samples.size() < 6)
                                samples.offer("parse 异常 | " + e.getClass().getSimpleName()
                                        + ": " + e.getMessage());
                        }
                    }
                } catch (InterruptedException ignored) {
                } finally {
                    TL.remove();          // 线程池必做
                    done.countDown();
                }
            });
        }

        start.countDown();
        done.await();
        pool.shutdown();

        System.out.println("[" + name + "] format 错乱 : " + formatErr.get());
        System.out.println("[" + name + "] parse 异常  : " + parseErr.get());
        System.out.println("[" + name + "] parse 错值  : " + parseWrong.get());
        System.out.println("---- 错误样例 ----");
        samples.forEach(s -> System.out.println("  " + s));
    }
}
