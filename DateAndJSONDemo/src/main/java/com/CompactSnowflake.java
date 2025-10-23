package com;

/**
 * @author Hj
 * @date 2025/10/14
 */
public class CompactSnowflake {
    // 起始时间戳（2020-01-01）
    private static final long START_STAMP = 1577836800000L;
    // 位分配
    private static final int TIMESTAMP_BITS = 19;
    private static final int MACHINE_BITS = 5;
    private static final int SEQUENCE_BITS = 8;
    // 最大值计算
    private static final long MAX_SEQUENCE = (1L << SEQUENCE_BITS) - 1;
    private static final long MAX_MACHINE = (1L << MACHINE_BITS) - 1;
    // 移位偏移量
    private static final long MACHINE_SHIFT = SEQUENCE_BITS;
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + MACHINE_BITS;

    private final int machineId;
    private int sequence;
    private long lastStamp;

    public CompactSnowflake(int machineId) {
        if (machineId > MAX_MACHINE || machineId < 0) {
            throw new IllegalArgumentException("机器ID超出范围");
        }
        this.machineId = machineId;
    }

    public synchronized int nextId() {
        long currentStamp = System.currentTimeMillis();
        if (currentStamp < lastStamp) {
            throw new RuntimeException("时钟回拨异常");
        }
        if (currentStamp == lastStamp) {
            sequence = (int) ((sequence + 1) & MAX_SEQUENCE);
            if (sequence == 0) {
                currentStamp = waitNextMillis();
            }
        } else {
            sequence = 0;
        }
        lastStamp = currentStamp;
        // 拼接ID：时间戳左移 + 机器ID左移 + 序列号
        return (int) (((currentStamp - START_STAMP) << TIMESTAMP_SHIFT)
                | (machineId << MACHINE_SHIFT)
                | sequence);
    }

    private long waitNextMillis() {
        long millis;
        do {
            millis = System.currentTimeMillis();
        } while (millis <= lastStamp);
        return millis;
    }
    public static void main(String[] args) {
        System.out.println(new CompactSnowflake(2).nextId());
    }
}
