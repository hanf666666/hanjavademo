package other.��ô����100���������ж����˼�����;

/**
 * to do
 *100���˻ش�����⣬��81�˴�Ե�һ�⣬91�˴�Եڶ��⣬85�˴�Ե����⣬79�˴�Ե����⣬74�˴�Ե����⡣
 * �������������������ϵ����㼰����ô����100���������ж����˼����أ�
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
            System.out.println("����");

        }else{
            for (int i = 1; i < 5+1; i++) {

                for (int j = 0;  j<2 ; j++) {
//                System.out.println();

                    System.out.print("��"+personcount+"������  ");
                    System.out.print("��"+i+"��");
                    if(j==0){
                        System.out.print("���� ");

                    }else {
                        System.out.print("���� ");


                    }


                }
                System.out.println();
            }

            --personcount;

        }


    }
}
