package com.排序.链表排序.交换类排序.快排;

public class DanLinkList {
    public Node headNode; // 定义一个头结点,null
    public Node currentNode; // 定义一个头结点,null
    public Node tailNode; // 定义一个尾结点,null
    private int pos = 0;// 节点的位置

    public DanLinkList() {
        this.headNode = null;
    }

    //尾插法
    public void addFirstNode尾(int data) {
        Node newNode = new Node(data);
        if(headNode ==null){
            headNode =newNode;
            currentNode=newNode;
            tailNode=newNode;
        }else{
            currentNode.nextNode=newNode;
            //重新赋引用
            currentNode=newNode;
            tailNode=newNode;
        }
    }

    // 显示出所有的节点信息
    public void displayAllNodes(Node headNode) {
        Node current = headNode;
        while (current != null) {
            current.display();
            current = current.nextNode;
        }
        System.out.println();
    }



}
