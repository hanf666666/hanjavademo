package com.排序.链表排序.交换类排序.快排;


public class Node {
    public Node nextNode; //指针域
    public int data;//数据域

    public Node(int data) {
        this.data = data;
    }

    //显示此节点
    public void display() {
        System.out.print(data + " ");
    }
}

