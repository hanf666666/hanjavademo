package com.Thread.排序.交换类排序.算数题.投硬币;

import java.util.Random;
/**/
public class cobin {

    public static void main(String[] args) {
        int total=0;
     for(int i=0;i<100000;i++){
         int count = chu(0,0,10);
         System.out.println();
         total +=count;
     }
        System.out.println("投了"+total/100000);



    }

    /**
     *
     * @param randcount 有randcount次了
     * @param count   投了count次了可出
     * @param numqiu  有randcount次了==numqiu   可出去
     * @return
     */
    public static int chu( int randcount,int count,int numqiu){
         int rand=  new Random().nextInt(2);
         count++;
         randcount+=rand;
         if(randcount>=numqiu){
             return count;
         }
        count =chu(randcount,count,numqiu);

     return count;
    }


}
