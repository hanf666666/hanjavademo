package other.���ַ���8��;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/26
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        String saStr = null;
        ArrayList aList = new ArrayList();
        while(sa.hasNext()){
            saStr = sa.nextLine();
            aList.add(saStr);
        }
        //System.out.println(aList.size());//����Ϊ��
        for(Object str: aList){
            //System.out.println("�����������");//����Ϊ��
            getStr(str);
        }
    }
    public static void getStr(Object strObj){//����ַ���
        //System.out.println("�����������");//����Ϊ��
        String str = String.valueOf(strObj);
        String numStr = "00000000";
        if(str == null || str.length()==0 || "".equals(str)){
            System.out.println("----����Ϊ��----");//����Ϊ��
        }else{
            if(str.length() <= 8 ){//���鲻Ϊ��
                str = str + numStr.substring(0,(8-str.length()));
                System.out.println(str);//����Ϊ��
            }else{//�ַ����ȴ���8
                System.out.println("----����>8----");//����Ϊ��
                getStrLengthB(strObj);
            }
        }
    }
    public static void getStrLengthB(Object strObj){//����ַ���
        String str = String.valueOf(strObj);
        String tempStr = "";
        String numStr = "00000000";
        tempStr = str.substring(0,8);
        str = str.substring(8,str.length());//�ַ���ʣ��
        //System.out.println("tempStr:"+tempStr+"  str:"+str);//����Ϊ��
        System.out.println(tempStr);//����Ϊ��
        if(str.length() == 0){
            return;
        }
        if(str.length() < 8){
            int len = (8-str.length());
            str = str + numStr.substring(0,len);
            System.out.println(str);//����Ϊ��
        }else{
            getStrLengthB(str);
        }

    }

}