package ali����.demo01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * to do
 *1����н�����ϵͳ�У�н����Ŀ֮�����������ϵ�����磺ʵ���ϼ�=Ӧ���ϼ�-�ۿ�ϼƣ�Ӧ���ϼ�=��������+�¶Ȳ������ۿ�ϼ�=ȱ�ڿۿ�+Ӧ��˰��
 * ʵ���ϼ�=Ӧ���ϼ�-�ۿ�ϼ�  ��Ӧ���ϼ�=��������+�¶Ȳ������ۿ�ϼ�=ȱ�ڿۿ�+Ӧ��˰��
 * ��������֮���������ϵʹ�ö�Ԫ��洢��������ʾ����
 * �� ʵ���ϼ� ��Ӧ���ϼƣ�
 * �� ʵ���ϼ� �� �ۿ�ϼ� ��
 * �� Ӧ���ϼ� �� �������� ��
 * �� Ӧ���ϼ� �� �¶Ȳ��� ��
 * �� �ۿ�ϼ� �� ȱ�ڿۿ� ��
 * �� �ۿ�ϼ� �� Ӧ��˰�� ��
 * ���еĶ�Ԫ�����һ�����顣���дһ��������������������飬�����ȷ����Ŀ����˳��
 * @author Hj
 * @date 2022/3/8
 */
public class Xchs {
    public static void main(String[] args){
        //�������鴦��
        Scanner sa = new Scanner(System.in);
        ArrayList array = new ArrayList();
        String[] strArray = null;
        String sysStr = null;
        String strTemp1 = null;
        String strTemp2 = null;
//        while(sa.hasNext()){
//            String str = sa.nextLine();//��ȡһ�У���ȡ����
//            array.add(str);
//        }
        array.add("�� ʵ���ϼ� ��Ӧ���ϼƣ�");
        array.add("�� ʵ���ϼ� �� �ۿ�ϼ� ��");
        array.add("�� Ӧ���ϼ� �� �������� ��");
        array.add("�� Ӧ���ϼ� �� �¶Ȳ��� ��");
        array.add("�� �ۿ�ϼ� �� ȱ�ڿۿ� ��");
        array.add("�� �ۿ�ϼ� �� Ӧ��˰�� ��");
        for(Object obj:array){
            int num = 1;
            String temp = String.valueOf(obj).trim();
            strArray = temp.substring(1,temp.length()).split(",");
            strTemp1 = strArray[0];
            strTemp2 = strArray[1];
            if("ʵ���ϼ�".equals(strTemp1)){
                if("Ӧ���ϼ�".equals(strTemp2)){
                    sysStr += "" + strTemp1 + " = "+strTemp2;
                }else{
                    sysStr += " - "+strTemp2;
                }
            }
            if("Ӧ���ϼ�".equals(strTemp1)){
                if("��������".equals(strTemp2)){
                    sysStr += "" + strTemp1 + " = "+strTemp2;
                }else{
                    sysStr += " + "+strTemp2;
                }
            }
            if("�ۿ�ϼ�".equals(strTemp1)){
                if("ȱ�ڿۿ�".equals(strTemp2)){
                    sysStr += "" + strTemp1 + " = "+strTemp2;
                }else{
                    sysStr += " + "+strTemp2;
                }
            }
            num++;
            if(num%2 == 1){
                sysStr += " ; ";
            }
        }
        System.out.println(sysStr);
    }
}
