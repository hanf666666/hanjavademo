package 树.二叉排序树;

//每个节点
public class Node<T extends Comparable<T>>{
    T data;   //T代表任意类型的数据
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
                "数据内容=" + data +
                ", 左节点引用=" + left +
                ", 右节点引用=" + right +
                '}';
    }
}
