package com.����.��������.����������.����;

public class DanLinkList {
    public Node headNode; // ����һ��ͷ���,null
    public Node currentNode; // ����һ��ͷ���,null
    public Node tailNode; // ����һ��β���,null
    private int pos = 0;// �ڵ��λ��

    public DanLinkList() {
        this.headNode = null;
    }

    //β�巨
    public void addFirstNodeβ(int data) {
        Node newNode = new Node(data);
        if(headNode ==null){
            headNode =newNode;
            currentNode=newNode;
            tailNode=newNode;
        }else{
            currentNode.nextNode=newNode;
            //���¸�����
            currentNode=newNode;
            tailNode=newNode;
        }
    }

    // ��ʾ�����еĽڵ���Ϣ
    public void displayAllNodes(Node headNode) {
        Node current = headNode;
        while (current != null) {
            current.display();
            current = current.nextNode;
        }
        System.out.println();
    }



}
