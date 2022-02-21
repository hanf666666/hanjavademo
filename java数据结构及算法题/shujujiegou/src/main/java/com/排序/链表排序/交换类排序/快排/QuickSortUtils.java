package com.����.��������.����������.����;

/**
 * to do
 *
 * ����
 * @author Hj
 * @date 2022/2/21*/
public class QuickSortUtils {



    public  static void  sortList(DanLinkList danLinkList){

        //danLinkList.currentNode����β�ڵ�
        quickSort(danLinkList.headNode,danLinkList.tailNode);

    }
    //����
    public  static void quickSort(Node headNode, Node tailNode) {
        //headNode != tailNode     ===>ͷ�ڵ��β�ڵ㲻��һ��
        if (headNode != tailNode) {
            Node node = partion(headNode, tailNode);
            quickSort(headNode, node);
            quickSort(node.nextNode, tailNode);
        }else{
            System.out.println("��������");
        }
    }

    public static Node partion(Node headNode, Node tailNode) {
        Node p1 = headNode;
        Node p2 = headNode.nextNode;

        //�ߵ�ĩβ��ͣ
        while (p2 != tailNode) {
            if (p2.data < headNode.data) {
                //p2.dataС��headNode.data=keyֵʱ��p1.nextNode��ֵ��p2Ҫ��������
                //p1��p2֮���key������ѡ����key=headNode.data
                p1 = p1.nextNode;
                int temp = p1.data;
                p1.data = p2.data;
                p2.data = temp;
            }else{
                //p2.data����headNode.data=keyֵʱ��p1��ǰ��һ��
                p2=p2.nextNode;
            }
        }

        //������ʱ��������p1��keyֵ
        if (p1 != headNode) {
            int temp = p1.data;
            p1.data = headNode.data;
            headNode.data = temp;
        }
        return p1;
    }


    /**
     *
     * @param headNode ԭʼ����ͷ�ڵ�
     * @return ���������ͷ�ڵ�
     */
   public  static Node reverseList(Node headNode){
        //�������Ϊ�ջ�ֻ��һ��Ԫ��ֱ�ӷ���
        if(headNode==null||headNode.nextNode==null){
            return headNode;
        }
        //��һ��Ԫ��
        Node p = headNode;
        //�ڶ���Ԫ��
        Node q = headNode.nextNode;
        Node tempNode = null;
        while(q!=null){
            //�޸�p��q��ָ�����
            tempNode = q.nextNode;
            q.nextNode=p;
            p = q;
            q = tempNode;
        }
        //��������β
        headNode.nextNode=null;
        //�޸�����ͷ
        headNode=p;
        return headNode;
    }
}
