package com.Thread.����.����������.������.ͶӲ��;

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
        System.out.println("Ͷ��"+total/100000);



    }

    /**
     *
     * @param randcount ��randcount����
     * @param count   Ͷ��count���˿ɳ�
     * @param numqiu  ��randcount����==numqiu   �ɳ�ȥ
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
