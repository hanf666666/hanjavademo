package com.����.��������.����������.����;

public class QuickSortMain {

    public static void main(String []args){
        int[] dataArray = {2,3,1,4,5};
        final DanLinkList danLinkList = new DanLinkList();
        for (int i : dataArray) {
            danLinkList.addFirstNodeβ(i);

        }
        System.out.print("ԭ�����ݴ�ӡ===>");
        danLinkList.displayAllNodes(danLinkList.headNode);
        QuickSortUtils.sortList(danLinkList);
        System.out.print("����֮�����ݴ�ӡ===>");
        danLinkList.displayAllNodes(danLinkList.headNode);
        System.out.print("����֮�������ݴ�ӡ===>");
        danLinkList.displayAllNodes(QuickSortUtils.reverseList(danLinkList.headNode));


    }


}
