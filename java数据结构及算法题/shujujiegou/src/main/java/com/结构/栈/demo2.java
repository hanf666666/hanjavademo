package com.�ṹ.ջ;

import java.util.Stack;

/**

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
