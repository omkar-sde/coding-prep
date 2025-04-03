package org.neetcode150.stack;

import java.util.*;
public class ValidParentheses_20 {
    /*
        Problem Statement: Brackets closed properly
        Intuition: HashMap. Close to open.
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put('}','{');
        closeToOpen.put(')','(');
        closeToOpen.put(']','[');

        for(char c: s.toCharArray()){
            if(!closeToOpen.containsKey(c)){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
                    stack.pop();
                }else return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses_20 obj = new ValidParentheses_20();

        String test1 = "()";
        System.out.println("Test 1: " + obj.isValid(test1)); // Expected: true

        String test2 = "()[]{}";
        System.out.println("Test 2: " + obj.isValid(test2)); // Expected: true

        String test3 = "(]";
        System.out.println("Test 3: " + obj.isValid(test3)); // Expected: false

        String test4 = "([)]";
        System.out.println("Test 4: " + obj.isValid(test4)); // Expected: false

        String test5 = "{[]}";
        System.out.println("Test 5: " + obj.isValid(test5)); // Expected: true
    }
}
