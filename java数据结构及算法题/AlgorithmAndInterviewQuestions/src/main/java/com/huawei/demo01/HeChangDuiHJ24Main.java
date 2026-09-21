package com.huawei.demo01;

import java.util.Arrays;

/**
 *HJ24 合唱队
 * 题目
 * 题解(450)
 * 讨论(515)
 * 排行
 * 面经
 * 中等  通过率：24.39%  时间限制：1秒  空间限制：32M
 * 知识点
 * 动态规划
 * 队列
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 音乐课上，老师将
 * n
 * n 位同学排成一排。老师希望在不改变同学相对位置的前提下，从队伍中选出最少数量的同学，使得剩下的同学排成合唱队形。
 * 记合唱队形中一共有
 * k

 * 输出描述：
 * 输出一个整数，代表最少需要出列的同学数量。
 */
public class HeChangDuiHJ24Main {
    public static void main(String[] args) {
        // 测试用例直接写入代码
        int[] h = {186, 186, 150, 200, 160, 130, 197, 200};
        int n = h.length;

        // inc[i]：以 i 结尾的最长严格递增子序列长度
        int[] inc = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (h[j] < h[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // dec[i]：以 i 开头的最长严格递减子序列长度
        int[] dec = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (h[j] < h[i]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (inc[i] >= 2 && dec[i] >= 2) {
                maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);
            }
        }

        int result = (maxLen == 0) ? n : n - maxLen;

        // 打印中间结果，方便验证
        System.out.println("inc = " + Arrays.toString(inc));
        System.out.println("dec = " + Arrays.toString(dec));
        System.out.println("maxLen = " + maxLen);
        System.out.println("最少出列人数 = " + result);
    }
}
