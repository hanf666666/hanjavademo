package ali����.���ʣ���ƻ����������ÿ���õ�����;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/10
 */
public class CreateTh extends Thread {
    public Mk mk;
    public volatile static int appCount = 9;

    public CreateTh(Mk mk) {
        this.mk = mk;

    }


    public void run() {
        while (appCount > 0 ) {
            appCount = appCount - mk.num;
            if(appCount<0){
                System.out.println("��ʣ��" +( appCount + mk.num )+ " ��ƻ��");

            }else{
                System.out.println("mk����"+mk.name+"���˸�"+mk.num+"ƻ��"+"��ʣ��" + appCount + " ��ƻ��");

            }
        }


    }
}


