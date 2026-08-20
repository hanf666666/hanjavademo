package com.scandemo.meitikeji;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 单条件
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemo3 {
    /**
     * 匹配行上下各显示的上下文行数
     */
    private static final int CONTEXT_LINES = 4;
    public static void main(String[] args) {

//        String line2 = " parkOrder.setStatus(OrderStatusEnum.PAID.getValue());";
//        if (
//                line2.contains("parkOrder.setStatus(")
//                        && (line2.contains("OrderStatusEnum.PAID") || line2.contains("3"))
////                        &&(file.getPath().contains("road"))
//
//
//        ) {
//            System.out.println(line2);
//        }


//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace", new FileFilter() {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getPath().indexOf(".git") > -1
                        || pathname.getPath().indexOf("sql") > -1
                        || pathname.getPath().indexOf("target") > -1
                        || pathname.getPath().indexOf(".idea") > -1
//                        || pathname.getPath().indexOf(".java") > -1
//                        || pathname.getPath().indexOf("txprod") == -1

                ) {
                    {
                        return false;
                    }

                }
                return true;
            }
        });

        for (File file : files) {
            List<String> lines = FileUtil.readLines(file, StandardCharsets.UTF_8);

            HashMap<String, Integer> matchMap = new HashMap<>();
            matchMap.put("open.keytop.cn", -1);


            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                int finalI = i;
                matchMap.forEach((k, v) -> {
                    if (line.contains(k)) {
                        matchMap.put(k, finalI);
                    }
                });
                Integer rangeWithin = isRangeWithin(matchMap.values());
//                if (rangeWithin != -1 && rangeWithin < 6) {
                if (!matchMap.values().contains(-1)) {
                    printWithContext(file.getPath(), lines, i);
                    matchMap.forEach((k, v) -> {
                                matchMap.put(k, -1);
                            }
                    );
                }

            }
        }
    }


    public static Integer isRangeWithin(Collection<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num == -1) return -1;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return max - min;
    }

    /**
     * 打印匹配行及其上下各 CONTEXT_LINES 行
     */
    private static void printWithContext(String filePath, List<String> lines, int matchIndex) {
        int start = Math.max(0, matchIndex - CONTEXT_LINES);
        int end = Math.min(lines.size() - 1, matchIndex + CONTEXT_LINES);

        System.out.println("========== " + filePath + " ==========");
        for (int i = start; i <= end; i++) {
            String marker = (i == matchIndex) ? ">>> " : "    ";
            System.out.printf("%s%-5d | %s%n", marker, i + 1, lines.get(i));
        }
        System.out.println();
    }


}


