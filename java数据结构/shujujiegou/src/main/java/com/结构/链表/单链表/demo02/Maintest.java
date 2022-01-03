package com.结构.链表.单链表.demo02;

import java.util.LinkedList;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/30
 */
public class Maintest {
    public static void main(String[] args) {
        final LinkedList<Integer> yunList = new LinkedList<Integer>();
        yunList.add(1);
        yunList.add(2);
        yunList.add(3);
        yunList.add(4);
//        yunList.

        final LinkList linkList = new LinkList();
        linkList.insertHeader(1);
        linkList.insertHeader(2);
        linkList.insertHeader(3);
        linkList.insertHeader(4);
        linkList.findAll();
        final LinkList linkList2 = new LinkList();
        linkList2.insertTailer(1);
        linkList2.insertTailer(2);
        linkList2.insertTailer(3);
        linkList2.insertTailer(4);
        linkList2.findAll();
    }
}
