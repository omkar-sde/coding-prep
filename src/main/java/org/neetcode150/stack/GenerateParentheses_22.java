package org.neetcode150.stack;

import java.util.*;

public class GenerateParentheses_22 {

    /*
        Problem Statement: generate ‘n’ valid parentheses
        Intuition: o = c & o = n; o < n; c < o
        Time Complexity: O(4^n / sqrt(n))
        Space Complexity: O(n)
     */
    private void backtrack(int open, int close, int n, List<String> res, StringBuilder stack) {
        if(open == close && open == n){
            res.add(stack.toString());
            return;
        }

        if(open < n){
            stack.append('(');
            backtrack(open + 1, close, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(close<open){
            stack.append(')');
            backtrack(open, close + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backtrack(0, 0, n, ans, stack);

        return ans;
    }

    public static void main(String[] args) {
        GenerateParentheses_22 gp = new GenerateParentheses_22();
        List<String> result = gp.generateParenthesis(3);
        System.out.println(result);
    }

}
