package ali����.���ʣ���ƻ����������ÿ���õ�����;

/**
 * to do
 * ����9��ƻ������2ֻ���ӣ�һ������ÿ����2��ƻ��������һ������ÿ����3��ƻ����
 * ���ʣ���ƻ����������ÿ���õ������������ֹͣ��ƻ��������java���߳�ģ�������������
 *
 * @author Hj
 * @date 2022/3/8
 */
public class demo {



    public static void main(String[] args) {

        Mk mk1 = new Mk("A",2);
        Mk mk2 = new Mk("B",3);

        CreateTh th1 = new CreateTh(mk1);
        CreateTh th2 = new CreateTh(mk2);

        th1.start();
        th2.start();

    }





}