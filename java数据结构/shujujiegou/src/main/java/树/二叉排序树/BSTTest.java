package 树.二叉排序树;

public class BSTTest {
    public static void main(String[] args) {
         int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};

        BST<Integer> nodeBST = new BST<Integer>();
        System.out.printf("== 原始数据: ");
        for (int i : a) {
            System.out.print(" ,"+i);
        }
        System.out.println();
        System.out.print("== 中序遍历数据:");
        for (int i = 0; i <a.length ; i++) {
            nodeBST.insert(a[i]);
        }

        //中序打印
       nodeBST.print中(nodeBST);










    }

}
