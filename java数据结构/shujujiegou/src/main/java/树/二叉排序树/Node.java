package ��.����������;

//ÿ���ڵ�
public class Node<T extends Comparable<T>>{
    T data;   //T�����������͵�����
    Node<T> left;
    Node<T> right;
    Node<T> parent;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "Node{" +
                "��������=" + data +
                ", ��ڵ�����=" + left +
                ", �ҽڵ�����=" + right +
                '}';
    }
}
