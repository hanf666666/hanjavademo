package com.�ṹ.����.������.demo02;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/30
 */
public class LinkList {
    Node nodeHeader = null;
    Node nodeTailer = null;

    /*β�巨*/
    public void insertTailer(int data) {
        final Node node = new Node(data);
        if (nodeTailer == null) {
            nodeTailer = node;
            nodeHeader = nodeTailer;
        } else {
            while (nodeTailer.nextNode != null) {
                nodeTailer = nodeTailer.nextNode;
            }
            nodeTailer.nextNode = node;
        }
    }

    /*ͷ�巨*/
    public void insertHeader(int data) {
        final Node node = new Node(data);
        if (nodeTailer == null) {
           nodeHeader=nodeTailer= node;
        } else {
            node.nextNode=nodeHeader;
            nodeHeader=node;
        }
    }

    public void findAll() {
        if (nodeHeader != null) {
            while (nodeHeader.nextNode != null) {
                System.out.print(nodeHeader.data+" ");
                nodeHeader = nodeHeader.nextNode;
            }
            System.out.print(nodeHeader.data+" ");
            System.out.println("");
        }
    }
}
