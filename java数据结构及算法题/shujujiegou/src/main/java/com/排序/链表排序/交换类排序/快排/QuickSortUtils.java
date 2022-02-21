package com.排序.链表排序.交换类排序.快排;

/**
 * to do
 *
 * 快排
 * @author Hj
 * @date 2022/2/21*/
public class QuickSortUtils {



    public  static void  sortList(DanLinkList danLinkList){

        //danLinkList.currentNode就是尾节点
        quickSort(danLinkList.headNode,danLinkList.tailNode);

    }
    //升序
    public  static void quickSort(Node headNode, Node tailNode) {
        //headNode != tailNode     ===>头节点和尾节点不是一个
        if (headNode != tailNode) {
            Node node = partion(headNode, tailNode);
            quickSort(headNode, node);
            quickSort(node.nextNode, tailNode);
        }else{
            System.out.println("遍历结束");
        }
    }

    public static Node partion(Node headNode, Node tailNode) {
        Node p1 = headNode;
        Node p2 = headNode.nextNode;

        //走到末尾才停
        while (p2 != tailNode) {
            if (p2.data < headNode.data) {
                //p2.data小于headNode.data=key值时，p1.nextNode的值和p2要发生交换
                //p1和p2之间的key都大于选定的key=headNode.data
                p1 = p1.nextNode;
                int temp = p1.data;
                p1.data = p2.data;
                p2.data = temp;
            }else{
                //p2.data大于headNode.data=key值时，p1向前走一步
                p2=p2.nextNode;
            }
        }

        //当有序时，不交换p1和key值
        if (p1 != headNode) {
            int temp = p1.data;
            p1.data = headNode.data;
            headNode.data = temp;
        }
        return p1;
    }


    /**
     *
     * @param headNode 原始链表头节点
     * @return 逆序后链表头节点
     */
   public  static Node reverseList(Node headNode){
        //如果链表为空或只有一个元素直接返回
        if(headNode==null||headNode.nextNode==null){
            return headNode;
        }
        //第一个元素
        Node p = headNode;
        //第二个元素
        Node q = headNode.nextNode;
        Node tempNode = null;
        while(q!=null){
            //修改p和q的指针放心
            tempNode = q.nextNode;
            q.nextNode=p;
            p = q;
            q = tempNode;
        }
        //设置链表尾
        headNode.nextNode=null;
        //修改链表头
        headNode=p;
        return headNode;
    }
}
