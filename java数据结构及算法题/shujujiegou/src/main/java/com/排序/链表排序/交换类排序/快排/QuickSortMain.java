package com.排序.链表排序.交换类排序.快排;

public class QuickSortMain {

    public static void main(String []args){
        int[] dataArray = {2,3,1,4,5};
        final DanLinkList danLinkList = new DanLinkList();
        for (int i : dataArray) {
            danLinkList.addFirstNode尾(i);

        }
        System.out.print("原生数据打印===>");
        danLinkList.displayAllNodes(danLinkList.headNode);
        QuickSortUtils.sortList(danLinkList);
        System.out.print("排序之后数据打印===>");
        danLinkList.displayAllNodes(danLinkList.headNode);
        System.out.print("排序之后倒序数据打印===>");
        danLinkList.displayAllNodes(QuickSortUtils.reverseList(danLinkList.headNode));


    }


}
