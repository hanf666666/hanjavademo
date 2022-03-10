package other.那么在这100人中至少有多少人及格呢;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * to do
 *100个人回答五道题，有81人答对第一题，91人答对第二题，85人答对第三题，79人答对第四题，74人答对第五题。
 * 答对三道题或三道题以上的人算及格，那么在这100人中至少有多少人及格呢？
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
