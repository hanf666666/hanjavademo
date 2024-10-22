package com.list.unsafe;

import cn.hutool.core.collection.ListUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2024/10/21
 */
@Slf4j
public class ArrayListDeleteDemo {
    public static void main(String[] args) {

        List<String> list = Collections.synchronizedList(new ArrayList<>()); // CopyOnWriteArrayList<>();
        List<String> newlist = new CopyOnWriteArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            newlist.add(item);
            iterator.remove();
        }
        log.info("newlist = {}", newlist);

//        List<List<String>> partitions = ListUtil.partition(list, 2);
//        partitions.forEach(item -> {
//                    log.info("item = {}", item);
//                    list.removeAll(item);
//                }
//
//        );
//        partitions.forEach(item -> {
//                    log.info("item = {}", item);
//                    list.removeAll(item);
//                }
//
//        );
        log.info("list = {}", list);

    }
}
