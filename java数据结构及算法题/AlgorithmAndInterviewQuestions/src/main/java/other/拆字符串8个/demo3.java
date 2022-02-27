package other.拆字符串8个;

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
        //System.out.println(aList.size());//数组为空
        for(Object str: aList){
            //System.out.println("进入数组遍历");//数组为空
            getStr(str);
        }
    }
    public static void getStr(Object strObj){//输出字符串
        //System.out.println("进入数组遍历");//数组为空
        String str = String.valueOf(strObj);
        String numStr = "00000000";
        if(str == null || str.length()==0 || "".equals(str)){
            System.out.println("----数组为空----");//数组为空
        }else{
            if(str.length() <= 8 ){//数组不为空
                str = str + numStr.substring(0,(8-str.length()));
                System.out.println(str);//数组为空
            }else{//字符长度大于8
                System.out.println("----数组>8----");//数组为空
                getStrLengthB(strObj);
            }
        }
    }
    public static void getStrLengthB(Object strObj){//输出字符串
        String str = String.valueOf(strObj);
        String tempStr = "";
        String numStr = "00000000";
        tempStr = str.substring(0,8);
        str = str.substring(8,str.length());//字符串剩下
        //System.out.println("tempStr:"+tempStr+"  str:"+str);//数组为空
        System.out.println(tempStr);//数组为空
        if(str.length() == 0){
            return;
        }
        if(str.length() < 8){
            int len = (8-str.length());
            str = str + numStr.substring(0,len);
            System.out.println(str);//数组为空
        }else{
            getStrLengthB(str);
        }

    }

}