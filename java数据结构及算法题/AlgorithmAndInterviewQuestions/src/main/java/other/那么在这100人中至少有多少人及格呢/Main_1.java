package other.��ô����100���������ж����˼�����;

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
            //������Ҷ�ӽڵ㣬���ջ������
            System.out.println(stack);
        } else {
            for (int i = 0; i < array.length; i++) {
                //tmepArray��һ����ʱ���飬���ھ���Ri
                //eg��1��2��3��ȫ���У���ȡ��1����ô��ʱtempArray�о���2��3
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

