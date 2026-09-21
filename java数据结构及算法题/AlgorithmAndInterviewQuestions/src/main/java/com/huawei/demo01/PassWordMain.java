package com.huawei.demo01;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 你需要书写一个程序验证给定的密码是否合格。
 *
 * 合格的密码要求：
 * ???长度不少于 88 位
 * ???必须包含大写字母、小写字母、数字、特殊字符中的至少三种
 * ???不能分割出两个独立的、长度大于 22 的连续子串，使得这两个子串完全相同；更具体地，如果存在两个长度大于 22 的独立子串 s1,s2s1?,s2? ，使得 s1=s2s1?=s2? ，那么密码不合法。
 *
 * 子串为从原字符串中，连续的选择一段字符（可以全选、可以不选）得到的新字符串。
 *
 * 可见字符集为 ASCII 码在 3333 到 126126 范围内的可见字符。您可以参阅下表获得其详细信息（您可能关注的内容是，这其中不包含空格、换行）。
 */
public class PassWordMain {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();

            if(str.length() <= 8){
                System.out.println("NG");
                continue;
            }
            if(getMatch(str)){
                System.out.println("NG");
                continue;

            }
            Pattern compile = Pattern.compile("^.*(.{3,}).*\\1.*$");
            if(compile.matcher(str).find()){
                System.out.println("NG");
                continue;

            }
            System.out.println("OK");
        }

    }
    // 校验是否有重复子串
    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str,l+1,r+1);
        }
    }
    // 检查是否满足正则
    private static boolean getMatch(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count >= 3){
            return false;
        }else{
            return true;
        }
    }
}
