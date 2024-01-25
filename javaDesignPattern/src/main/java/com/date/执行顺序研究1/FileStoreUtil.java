package com.date.Ö´ÐÐË³ÐòÑÐ¾¿1;

import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/23
 */
public class FileStoreUtil {
    private final static Map<String, String> fileStoreMap =statica1();
    public static final Map<String, String> sortedFileStoreList=null;

    static {
        System.out.println(fileStoreMap.size());
        System.out.println("22222222");
        System.out.println(fileStoreMap.size());
    }

    private static Map<String, String> statica1() {
        System.out.println("1111111111");
        return new HashMap<>();
    }

}
