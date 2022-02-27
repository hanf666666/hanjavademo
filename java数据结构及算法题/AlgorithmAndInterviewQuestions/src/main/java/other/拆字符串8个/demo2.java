package other.²ð×Ö·û´®8¸ö;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/26
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> strList = new ArrayList<String>();
        while (scanner.hasNextLine()){
            String saStr = scanner.nextLine();
            strList.add(saStr);
        }
//        strList.add("1234567887654321");
       for(String str: strList){
           str+="0000000";
           final int rowCount = str.length()/8;
           for (int i = 0; i <rowCount; i++) {
               int startIndex=0+(i+1-1)*8;
               int endIndex=0+(i+2-1)*8;

               System.out.println(str.substring(startIndex,endIndex));
           }


        }
    }

}