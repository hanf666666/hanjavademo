package other.那么在这100人中至少有多少人及格呢;

import java.util.Stack;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/10
 */
public class Main_1 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String[] data = {"A", "B","C"};
        perm(data,stack);
    }
    public static void perm(String[] array, Stack<String> stack) {
        if(array.length <= 0) {
            //进入了叶子节点，输出栈中内容
            System.out.println(stack);
        } else {
            for (int i = 0; i < array.length; i++) {
                //tmepArray是一个临时数组，用于就是Ri
                //eg：1，2，3的全排列，先取出1，那么这时tempArray中就是2，3
                String[] tempArray = new String[array.length-1];
                System.arraycopy(array,0,tempArray,0,i);

                System.arraycopy(array,i+1,tempArray,i,array.length-i-1);


                stack.push(array[i]);
                perm(tempArray,stack);
                stack.pop();
            }
        }
    }
}

