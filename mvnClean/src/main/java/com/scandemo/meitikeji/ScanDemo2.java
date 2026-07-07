package com.scandemo.meitikeji;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描文件，匹配条件后打印附近上下文代码
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemo2 {

    /** 匹配行上下各显示的上下文行数 */
    private static final int CONTEXT_LINES = 4;

    public static void main(String[] args) {
        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                String path = pathname.getPath();
                return path.indexOf(".git") == -1
                        && path.indexOf("sql") == -1
                        && path.indexOf("target") == -1
                        && path.indexOf(".idea") == -1;
            }
        });

        for (File file : files) {
            List<String> lines = FileUtil.readLines(file, StandardCharsets.UTF_8);
            int count=0;
            int tempLine=0;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                List<String> matchMap = new ArrayList<>();
                matchMap.add("opoi.channel_order channelOrder");
                matchMap.add("opoi.plate_no plateNo,");
                matchMap.add("opoi.park_id parkId,");

                // 条件1: parkOrder.setStatus(  且  条件2: OrderStatusEnum.PAID 或 3
                if (matchMap.stream().anyMatch(s -> line.contains(s)) ) {
                    tempLine=i;
                    count++;
                }
                if (matchMap.size()==count && i-tempLine<4){
                    printWithContext(file.getPath(), lines, i);
                    count=0;
                    tempLine=0;
                }
            }
        }
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