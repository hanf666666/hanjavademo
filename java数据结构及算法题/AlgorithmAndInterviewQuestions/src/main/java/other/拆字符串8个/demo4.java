package other.拆字符串8个;

/**
 * to do
 *
 * @author Hj
 * @date 2022/2/26
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class demo4 {
    public static void main(String[] args){
        File f = new File("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\java数据结构及算法题\\AlgorithmAndInterviewQuestions\\src\\main\\java\\other\\拆字符串8个\\test.txt");// 指定操作文件
        Scanner scan = null;
        try {
            scan = new Scanner(f); // 从文件接收数据
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer str = new StringBuffer(); // 用于接收数据
        System.out.println(scan.hasNext());
        while (scan.hasNext()) { // 判断是否还有内容
            str.append(scan.next()).append("\n");// 取出内容
        }
        System.out.println(str);
    }
}

