package com.结构.链表.单链表.demo01;


public class Node {
    protected Node next; //指针域
    public int data;//数据域

    public Node(int data) {
        this.data = data;
    }

    //显示此节点
    public void display() {
        System.out.print(data + " ");
    }
}

