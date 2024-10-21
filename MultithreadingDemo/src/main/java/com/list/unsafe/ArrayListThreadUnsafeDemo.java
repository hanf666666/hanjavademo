package com.list.unsafe;

/**
 * to do
 * 多线程写入得到得最终数据不一致问题
 * @author Hj
 * @date 2024/10/21
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListThreadUnsafeDemo {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
        //添加的数据是完整的
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list =new CopyOnWriteArrayList<>();

        // 创建多个线程，每个线程都向列表中添加元素
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    list.add(j); // 这里没有进行同步处理
                }
            }).start();
        }

        // 为了确保所有线程都执行完毕，这里简单地等待一段时间（不推荐在生产代码中使用）
        try {
            Thread.sleep(5000); // 等待5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印列表大小，理论上应该是100000（1000个线程，每个线程添加100个元素）
        // 但由于线程不安全，实际大小可能会小于这个值
        System.out.println("List size: " + list.size());

        // 打印列表内容（可能会发现重复的元素或缺失的元素）
        // System.out.println(list);
    }
}