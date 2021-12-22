package com.结构.链表.单链表;

public class LinkList尾插法 {
    static Node head主;//头结点
    //插入
    public static void insert( int data) {
        Node node = new Node(data);
        //尾插法先要确定头结点是否为空，空的话先将第一个结点给头结点
        Node 尾 = head主;//尾节点
        if (head主 == null) {
            //第一次会进来
            node.next = head主;//这里为null
            head主 = node;  //下次head主,就走else
        } else {
            while (尾.next != null) {
                尾 = 尾.next;//尾结点始终指向最后一个结点
                }
            尾.next=node;
            //在尾部插入新结点
            }
    }
    public static void selectAll(){
        while (head主.next!=null){
            System.out.println(head主.data);
            head主=head主.next;
        }
        System.out.println(head主.data);

    }


    public static void main (String[]args){
            int[] datas = {1, 2, 3, 4, 5, 6};
            for (int data : datas) {
               insert(data);
            }
           selectAll();

        }
    }
