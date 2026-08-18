package com.map;

import java.util.HashMap;

/**
 * @author Hj
 * @date 2026/8/18
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Long, String> map = new HashMap<>();

        System.out.println(hash(1));
        for (long i = 0; i < 80; i++) {
            //链表长度大于等于阈值 8（TREEIFY_THRESHOLD = 8）
            //哈希表的数组长度大于等于 64（MIN_TREEIFY_CAPACITY = 64）
            map.put(i*128, "a" + i);

        }


    }

    /**
     * 异或相吸为 1
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h=key.hashCode();
        return  (h  ) ^ (h >>> 16);
    }
}
