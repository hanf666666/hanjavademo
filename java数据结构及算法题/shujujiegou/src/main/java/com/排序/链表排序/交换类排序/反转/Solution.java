package com.≈≈–Ú.¡¥±Ì≈≈–Ú.Ωªªª¿‡≈≈–Ú.∑¥◊™;

import com.≈≈–Ú.¡¥±Ì≈≈–Ú.Ωªªª¿‡≈≈–Ú.øÏ≈≈.Node;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/1
 */
public class Solution {
    public static Node ReverseList(Node head) {

        if (head == null || head.nextNode == null)
            return head;
        else {
            Node node1 = head;
            Node node2 =head.nextNode;
            Node tempNode3=null;
            while (node2!= null) {
                tempNode3= node2.nextNode;
                node2.nextNode=node1;
                node1=node2;
                node2=tempNode3;

            }
            head.nextNode=null;
            head=node1;
            return head;
        }

    }

}
