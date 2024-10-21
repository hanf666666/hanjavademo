package com.list.ModificationException;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2024/10/21
 */
@Slf4j
public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // 获取迭代器
        Iterator<String> iterator = list.iterator();

        // 使用迭代器遍历列表
        while (iterator.hasNext()) {
            String item = iterator.next();
            list.add("D");
            // 在遍历过程中，直接通过列表对象修改列表（而不是通过迭代器）
            if (item.equals("B")) {
                List<String> list2 = new ArrayList<>();
                list2.add(item);
                list2.add("C");
                list.removeAll(list2);  // 这将导致 ConcurrentModificationException
            }
            log.info("list--->{}", list);
            System.out.println(item);
        }

        // 注意：由于上面的代码会抛出异常，下面的代码通常不会被执行
        System.out.println("遍历完成");
    }
}

