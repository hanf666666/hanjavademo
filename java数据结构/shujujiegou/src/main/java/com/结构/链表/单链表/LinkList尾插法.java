package com.�ṹ.����.������;

public class LinkListβ�巨 {
    static Node head��;//ͷ���
    //����
    public static void insert( int data) {
        Node node = new Node(data);
        //β�巨��Ҫȷ��ͷ����Ƿ�Ϊ�գ��յĻ��Ƚ���һ������ͷ���
        Node β = head��;//β�ڵ�
        if (head�� == null) {
            //��һ�λ����
            node.next = head��;//����Ϊnull
            head�� = node;  //�´�head��,����else
        } else {
            while (β.next != null) {
                β = β.next;//β���ʼ��ָ�����һ�����
                }
            β.next=node;
            //��β�������½��
            }
    }
    public static void selectAll(){
        while (head��.next!=null){
            System.out.println(head��.data);
            head��=head��.next;
        }
        System.out.println(head��.data);

    }


    public static void main (String[]args){
            int[] datas = {1, 2, 3, 4, 5, 6};
            for (int data : datas) {
               insert(data);
            }
           selectAll();

        }
    }
