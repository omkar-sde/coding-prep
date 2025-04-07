package org.neetcode150.stack;

import java.util.*;

public class EvaluateReversePolishNotation_150 {
    /*
        Problem Statement: Postfix expression without parentheses.
        Intuition: if number push in stack, if operand pop two, perform push.
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 sol = new EvaluateReversePolishNotation_150();

        String[] tokens1 = {"2", "1", "+", "3", "*"}; // (2 + 1) * 3 = 9
        String[] tokens2 = {"4", "13", "5", "/", "+"}; // 4 + (13 / 5) = 6

        System.out.println("Result 1: " + sol.evalRPN(tokens1)); // Output: 9
        System.out.println("Result 2: " + sol.evalRPN(tokens2)); // Output: 6
    }

}
