package other.���ַ���8��;

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
        File f = new File("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\java���ݽṹ���㷨��\\AlgorithmAndInterviewQuestions\\src\\main\\java\\other\\���ַ���8��\\test.txt");// ָ�������ļ�
        Scanner scan = null;
        try {
            scan = new Scanner(f); // ���ļ���������
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuffer str = new StringBuffer(); // ���ڽ�������
        System.out.println(scan.hasNext());
        while (scan.hasNext()) { // �ж��Ƿ�������
            str.append(scan.next()).append("\n");// ȡ������
        }
        System.out.println(str);
    }
}

