package com.huawei.demo01;

import java.util.Scanner;

/**
 * to do
 *��Ҫ������ַ���,�����һ�����ʳ���
 * @author Hj
 * @date 2022/1/19
 */
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String s = scanner.nextLine();
        final String[] s1 = s.trim().split(" ");
        System.out.println(s1[s1.length-1].length());
    }
}
