package com.Thread.排序.交换类排序.算数题.字符串反转加;

public class han {
    public static void main(String[] args) {
        String s="1-23-456-7-8-9";
        String reverse = reverse(s);
        System.out.println(reverse.length());
        System.out.println(reverse);



        System.out.println(s.substring(0,5));

    }
    static String reverse(String s){
        String s2="";
        String[] split0 =s.replace("-","").split("");

        for (int i=split0.length;i>0;i--) {
            s2+=split0[i-1];
        }

        return s2;
    }


    static String bian(String s,int n){
        int zuihouyu=s.length()%n;
        int shuzizu=s.length()/n;
        String new1="";
        int zuihou=0;
        for (int i=0;i<s.length();i+=n)
        {
            if((i+n)>(s.length()-1)){
                new1+= s.substring(i,s.length());
            }
            else {
                //substring(index,长度)
                new1 += s.substring(i, i + n) + "-";

                zuihou = i;
            }

        }


        return new1;
    }


}
