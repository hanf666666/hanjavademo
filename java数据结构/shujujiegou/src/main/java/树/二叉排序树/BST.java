package ��.����������;

//binary search tree
public class BST<T extends Comparable<T>> {
    Node<T> mRoot;//��һ���ڵ�,ȡ��ΪmRoot

    //new һ���ڵ����
    public void insert(T data) {
        Node<T> node = new Node<>(data, null, null);

        // ����½����ʧ�ܣ��򷵻ء�
        if (node != null) {
            //�����ϲ�ڵ�,�漰��������
            insert(node);
        }
    }

    //�����ϲ�ڵ�,�漰��������
    private void insert(Node<T> node) {
        int cmp;//�Ƚϴ�С-1 0 1
        Node<T> tempRoot = null;
        Node<T> oldTreeNode = this.mRoot;//һ���ڵ�Ҳ����

        //�ǵ�һ���ڵ�ͽ���,����Ҫ�����Ƚ�,ѭ��
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


    //�������������ӡ����
    public void print��(BST<T> bst) {
        Node<T> mRoot���� = bst.mRoot;
        //�������
        search��(mRoot����);


    }

    //�������
    private void search��(Node<T> mRoot����) {
        if (mRoot���� != null) {
            search��(mRoot����.left);
            System.out.print(mRoot����.data + " ");
            search��(mRoot����.right);
        }

    }





}



