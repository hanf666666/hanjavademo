package other.��ô����100���������ж����˼�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * to do
 *100���˻ش�����⣬��81�˴�Ե�һ�⣬91�˴�Եڶ��⣬85�˴�Ե����⣬79�˴�Ե����⣬74�˴�Ե����⡣
 * �������������������ϵ����㼰����ô����100���������ж����˼����أ�
 * @author Hj
 * @date 2022/3/10
 */
public class demo2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        System.out.println(stack);
        stack.pop();
        stack.push("b");
        System.out.println(stack);
        stack.pop();
        stack.push("c");
        System.out.println(stack);

    }
}
