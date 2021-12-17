package ��.����������;

import ��.��ڶ�����ƽ��.RBTree;

/*
*
== ԭʼ����: 10 40 30 60 90 70 20 50 80
== ǰ�����: 30 10 20 60 40 50 80 70 90
== �������: 10 20 30 40 50 60 70 80 90
== �������: 20 10 50 40 70 90 80 60 30
== ��Сֵ: 10
== ���ֵ: 90
== ������ϸ��Ϣ:
30(B) is root
10(B) is 30's   left child
20(R) is 10's  right child
60(R) is 30's  right child
40(B) is 60's   left child
50(R) is 40's  right child
80(B) is 60's  right child
70(R) is 80's   left child
90(R) is 80's  right child

* */
public class RBTreeTest {

    private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = false;    // "����"�����ļ�⿪��(false���رգ�true����)
    private static final boolean mDebugDelete = false;    // "ɾ��"�����ļ�⿪��(false���رգ�true����)

    public static void main(String[] args) {
            int i, ilen = a.length;
        RBTree<Integer> tree=new RBTree<Integer>();

        System.out.printf("== ԭʼ����: ");
        for(i=0; i<ilen; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        for(i=0; i<ilen; i++) {
            tree.insert(a[i]);
            // ����mDebugInsert=true,����"��Ӻ���"
            if (mDebugInsert) {
                System.out.printf("== ��ӽڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        System.out.printf("== ǰ�����: ");
        tree.preOrder();

        System.out.printf("\n== �������: ");
        tree.inOrder();

        System.out.printf("\n== �������: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== ��Сֵ: %s\n", tree.minimum());
        System.out.printf("== ���ֵ: %s\n", tree.maximum());
        System.out.printf("== ������ϸ��Ϣ: \n");
        tree.print();
        System.out.printf("\n");

        // ����mDebugDelete=true,����"ɾ������"
        if (mDebugDelete) {
            for(i=0; i<ilen; i++)
            {
                tree.remove(a[i]);

                System.out.printf("== ɾ���ڵ�: %d\n", a[i]);
                System.out.printf("== ������ϸ��Ϣ: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        // ���ٶ�����
        tree.clear();
    }
}
