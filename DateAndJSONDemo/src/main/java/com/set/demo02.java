package com.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2022/7/27
 */
public class demo02 {
    public static void main(String[] args) {
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);

        List<Integer> ids2=new ArrayList<>();
        ids2.add(1);
        ids2.add(2);
        ids2.add(3);


        boolean b = ids.retainAll(ids2);
        System.out.println("交集：" + ids);
        System.out.println("parkIDs: "+ids+",b: "+b);
//        System.out.println("差集：" + result);


//        System.out.println("并集：" + result);



    }
}
