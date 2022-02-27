package other.²ð×Ö·û´®8¸ö;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/26
 */
import java.util.*;
public class demo{
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        ArrayList aList = new ArrayList();
        if(sa.hasNextLine()){
            String saStr = sa.nextLine();
            aList.add(saStr);
        }


        for(Object str: aList){
            getStr(str);
        }
    }
    public static void getStr(Object strObj){
        String str = String.valueOf(strObj);
        char[] charArray=str.toCharArray();
        String str8="";
        for(int i=1;i<charArray.length+1;i++){

            if(i%8==0){
                str8+=charArray[i-1]+"";
                System.out.println(str8);
                str8="";
            }else{
                str8+=charArray[i-1]+"";
            }
        }
        int count=str8.length();
        if(count>0){
            for(int i=0;i<8-count;i++){
                str8+="0";
            }
            System.out.println(str8);

        }
    }
}