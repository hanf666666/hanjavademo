package com.�ṹ.��.��ڶ�����ƽ��;

public class RBTNode<T extends Comparable<T>> {

    //����ture,����false
    private static final boolean RED   = false;
    private static final boolean BLACK = true;
    boolean color;        // ��ɫ
    T key;                // �ؼ���(��ֵ),����
    RBTNode<T> left;      // ����
    RBTNode<T> right;     // �Һ���
    RBTNode<T> parent;    // �����

    public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return ""+key+(this.color==RED?"(R)":"B");
    }
}
