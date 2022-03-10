package other.那么在这100人中至少有多少人及格呢;

/**
 * to do
 *100个人回答五道题，有81人答对第一题，91人答对第二题，85人答对第三题，79人答对第四题，74人答对第五题。
 * 答对三道题或三道题以上的人算及格，那么在这100人中至少有多少人及格呢？
 * @author Hj
 * @date 2022/3/10
 */
public class demo {
    public static void main(String[] args) {
        int personcount=1;
        for (int i = 1; i < personcount+1; i++) {
            perPerson(i);
            System.out.println();
        }



    }

    private static void perPerson(int personcount) {

        if(personcount<=0){
            System.out.println("结束");

        }else{
            for (int i = 1; i < 5+1; i++) {

                for (int j = 0;  j<2 ; j++) {
//                System.out.println();

                    System.out.print("第"+personcount+"个人做  ");
                    System.out.print("第"+i+"题");
                    if(j==0){
                        System.out.print("做错 ");

                    }else {
                        System.out.print("做对 ");


                    }


                }
                System.out.println();
            }

            --personcount;

        }


    }
}
