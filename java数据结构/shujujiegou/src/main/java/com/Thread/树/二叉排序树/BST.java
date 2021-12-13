package com.Thread.树.二叉排序树;

//binary search tree
public class BST<T extends Comparable<T>> {
    Node<T> mRoot;//第一个节点,取名为mRoot

    //new 一个节点出来
    public void insert(T data) {
        Node<T> node = new Node<>(data, null, null);

        // 如果新建结点失败，则返回。
        if (node != null) {
            //往树上插节点,涉及插入排序
            insert(node);
        }
    }

    //往树上插节点,涉及插入排序
    private void insert(Node<T> node) {
        int cmp;//比较大小-1 0 1
        Node<T> tempRoot = null;
        Node<T> oldTreeNode = this.mRoot;//一个节点也是树

        //非第一个节点就进入,里面要发生比较,循环
        while (oldTreeNode != null) {
            tempRoot=oldTreeNode;
            cmp = oldTreeNode.getData().compareTo(node.getData());
            if (cmp > 0) {
                oldTreeNode.left = node;
            } else {
                oldTreeNode.right = node;
            }

        }

/*        if (y!=null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0)
                y.left = node;
            else
                y.right = node;
        } else {
            this.mRoot = node;
        }*/




    }


    //将排序二叉树打印出来
    public void print中(BST<T> bst) {
        Node<T> mRoot遍历 = bst.mRoot;
        //中序遍历
        search中(mRoot遍历);


    }

    //中序遍历
    private void search中(Node<T> mRoot遍历) {
        if (mRoot遍历 != null) {
            search中(mRoot遍历.left);
            System.out.print(mRoot遍历.data + " ");
            search中(mRoot遍历.right);
        }

    }





}



