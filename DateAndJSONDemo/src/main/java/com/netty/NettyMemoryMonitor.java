package com.netty;

import io.netty.buffer.PoolArenaMetric;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocatorMetric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Netty 内存池监控
 */
public class NettyMemoryMonitor {

    private static final Logger log =
            LoggerFactory.getLogger(NettyMemoryMonitor.class);

    private static String mb(long bytes) {
        return String.format("%.2f MB", bytes / 1024.0 / 1024.0);
    }

    /**
     * 统计 Netty 内存池
     */
    public static void printMemory() {

        PooledByteBufAllocator allocator =
                PooledByteBufAllocator.DEFAULT;

        PooledByteBufAllocatorMetric metric =
                allocator.metric();

        log.info("================ Netty Memory ================");

        // 堆内存池
        log.info("Heap Used: {}", mb(metric.usedHeapMemory()));

        // 直接内存池
        log.info("Direct Used: {}", mb(metric.usedDirectMemory()));

        // 堆内存 Arena 数量
        log.info("Heap Arenas: {}", metric.numHeapArenas());

        // 直接内存 Arena 数量
        log.info("Direct Arenas: {}", metric.numDirectArenas());

        // 小对象缓存
        log.info("Small Cache Size: {}", metric.smallCacheSize());

        // 普通缓存
        log.info("Normal Cache Size: {}", metric.normalCacheSize());

        // 大对象缓存
        log.info("ThreadLocal Cache Size: {}", metric.numThreadLocalCaches());

        // 堆内存 Arena 详情
//        printArenas("HEAP", metric.heapArenas());

        // 直接内存 Arena 详情
//        printArenas("DIRECT", metric.directArenas());


        for (PoolArenaMetric arena :
                PooledByteBufAllocator.DEFAULT.metric().directArenas()) {

            log.info(
                    "allocations={}, deallocations={}, activeAllocations={}, activeBytes={}",
                    arena.numAllocations(),
                    arena.numDeallocations(),
                    arena.numActiveAllocations(),
                    arena.numActiveBytes()
            );
        }
        log.info("================================================");
    }

    private static void printArenas(
            String type,
            List<PoolArenaMetric> arenas) {

        for (int i = 0; i < arenas.size(); i++) {

            PoolArenaMetric arena = arenas.get(i);

            log.info(
                    "[{} Arena-{}] allocations={}, deallocations={}, activeBytes={}",
                    type,
                    i,
                    arena.numAllocations(),
                    arena.numDeallocations(),
                    mb(arena.numActiveBytes())
            );
        }
    }
}
