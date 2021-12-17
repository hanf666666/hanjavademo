package com.Thread.排序.交换类排序.算数题.递归求最大值;

public class maxvalue {

        public static void main(String[] args) {
            int arr[]={11,22,3,3,3,4,4,6,23};
            System.out.println(arr.length+"index");
            System.out.println(getMax(arr,0,arr.length-1));

        }
        public static int getMax(int[] arr, int l, int r) {
            if (l == r) {
                return arr[l];
            }
            int mid = (l + r) / 2;
            int maxLeft = getMax(arr, l, mid);
            int maxRight = getMax(arr, mid + 1, r);
            return Math.max(maxLeft, maxRight);
        }






}
