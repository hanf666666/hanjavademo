package ��.����������;

public class BSTTest {
    public static void main(String[] args) {
         int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};

        BST<Integer> nodeBST = new BST<Integer>();
        System.out.printf("== ԭʼ����: ");
        for (int i : a) {
            System.out.print(" ,"+i);
        }
        System.out.println();
        System.out.print("== �����������:");
        for (int i = 0; i <a.length ; i++) {
            nodeBST.insert(a[i]);
        }

        //�����ӡ
       nodeBST.print��(nodeBST);










    }

}
